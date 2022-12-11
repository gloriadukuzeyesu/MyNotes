public interface IHeap <T extends Comparable<T>>{

    /**
     * insert a new data into the heap
     * @param data new data to be inserted
     * @return
     */
    IHeap<T> insert(T data);

    /**
     * remove the root from the heap
     * @return the root
     */
    T getRoot();

    /**
     * sort the heap using sort algorithm
     */
    void sort();
}
