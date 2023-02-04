package StringManipul;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
    private double sum_;
    private int maxSize_;
    private Queue<Integer> window_;
    /**
     * Initializes a MovingAverage with a
     * capacity of `size`.
     */
    public MovingAverage(int size) {
        // TODO: initialize your MovingAverage.
        this.window_ = new LinkedList<>();
        maxSize_ = size;
        this.sum_ = 0.0;
    }

    /**
     * Adds `val` to the stream of numbers
     * and returns the current average of the numbers.
     */
    public double next(int val) {
        if(window_.size() == maxSize_) {
            sum_ -= window_.remove();
        }
        window_.add(val);
        sum_ += val;
        return sum_ / window_.size();
    }

    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage(3);
        var average = movingAverage.next(5);
        movingAverage.next(9);
        var xx = movingAverage.next(7);
//        System.out.println(xx);

//        System.out.println(average);
        MovingAverage m = new MovingAverage(3);
        var resp1 = m.next(3); //returns 3 because (3 / 1) = 3
        System.out.println(resp1);
        var rep2 = m.next(5); //returns 4 because (3 + 5) / 2 = 4
        System.out.println(rep2);
        var rep3 = m.next(7); //returns 5 because (3 + 5 + 7) / 3 = 5
        System.out.println(rep3);
        var rep4 = m.next(6); //returns 6 because (5 + 7 + 6) / 3 = 6
        //System.out.println(rep4);
        System.out.println(m.next(6));

    }

}
