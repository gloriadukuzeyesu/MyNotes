import java.util.Arrays;
import java.util.SortedMap;

public abstract class Heap <T extends Comparable<T>> implements IHeap<T>{
    // abstract because max and min class heap will extend this class, and they share many things in common
    protected T[] heap;
    protected int position = -1; //  help keep tract of the last element in the heap

    public Heap(){
        heap = (T[]) new Comparable[2]; // started from 2 since it is goin to be a resizable array
    }
    @Override
    public IHeap<T> insert (T data) {
        if(isFull()) {
            resize(2 * heap.length); // decided to double the capacity in case it is full
        }
        heap[position++] = data;
        fixUpward();
        return this;
    }

    protected abstract void fixUpward();

    protected abstract void fixDownWard(int endIndex);

    private void resize(int capacity) {
        System.arraycopy(heap, 0, heap = (T[]) new Comparable[capacity], 0, position + 1);
    }

    private boolean isFull() {
        return position == heap.length -1;
    }

    protected void swap(int firstIndex, int secondIndex) {
        T temp = heap[firstIndex];
        heap[firstIndex] = heap[secondIndex];
        heap[secondIndex] = temp;
    }

   @Override
    public void sort(){
       // this should be repeated until there are no nodes left inside the heap
       for( int i = 0; i < position; i++) {
            swap(0,position - i);
            fixDownWard(position - i-1);
       }
       Arrays.stream(heap).forEach(System.out::println);
       // maximu heap: print in the ascending order
       // minimum heap : print in descending order
   }

    @Override
    public T getRoot() {
        if(isEmpty()) {
            return null; // to avoid null pointer exception
        }
        T result = heap[0];
        heap[0] = heap[position--]; // put it at the root
        heap[position + 1] = null; // to remove the lst elem
        fixDownWard(position);
        return result;
    }

    private boolean isEmpty() {
        return heap.length == 0;
    }
}
