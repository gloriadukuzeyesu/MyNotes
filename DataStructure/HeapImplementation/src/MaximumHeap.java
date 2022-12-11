public class MaximumHeap <T extends Comparable<T>> extends Heap<T>{

    protected void fixUpward() {
        // comparing the inserted data with the current node and move it until it reaches it correct spot
        // get the index of the element just added and its parent index
        int index = position;
        int parentIndex = (index -1) / 2; // formula to get the parent index from child index

        // while the value of the child is bigger than the value of the parent and haven't yet reached the top of the tree, swap
        while (parentIndex >= 0 && heap[index].compareTo(heap[parentIndex]) > 0) {
            swap(index, parentIndex);
            // move the nodes upwards
            index = parentIndex;
            parentIndex = (index -1 ) / 2;
        }
    }

    protected void fixDownWard(int endIndex) {
        if(endIndex == -1) {
            return; // meanin the tree is empty
        }
        int index = 0;
        while ( index <= endIndex) {
            // since we are starting from the root, we can't get the index of the parent like we did  in the min hip
            // instead retried the index of the children
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;

            if( leftChildIndex > endIndex){
                break;
            }

            // now decide which child to swap with
            int childToSwapIndex = rightChildIndex > endIndex
                    ? leftChildIndex
                    : heap[leftChildIndex].compareTo(heap[rightChildIndex]) < 0
                            ? leftChildIndex
                            : rightChildIndex;
            if( heap[index].compareTo(heap[childToSwapIndex]) < 0){
                break;
            }
            swap(index,childToSwapIndex);
            index = childToSwapIndex;
        }

    }
}
