package Q_295_FindMedianFromDataStream;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindMedianFromDataStream {

    public static void main(String[] args) {

//        ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
//        [[], [1], [2], [], [3], []]
        MedianFinder medianFinder = new MedianFinder();
        System.out.print(medianFinder.findMedian() +" ,");
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.print(medianFinder.findMedian() +" ,");
        medianFinder.addNum(3);
        System.out.print(medianFinder.findMedian() +" ");
    }

//    List<Integer> store; // resize-able container
//
//    // Adds a number into the data structure.
//    void addNum(int num) {
//        if (store.size() == 0)
//            store.add(num);
//        else
//            store.add(lower_bound(store.begin(), store.end(), num), num);     // binary search and insertion combined
//    }
//
//    // Returns the median of current data stream
//    double findMedian()
//    {
//        int n = store.size();
//        return n & 1 ? store[n / 2] : ((double) store[n / 2 - 1] + store[n / 2]) * 0.5;
//    }

}


class MedianFinder {

    private Queue<Long> small = new PriorityQueue(),
            large = new PriorityQueue();

    public void addNum(int num) {
        large.add((long) num);
        small.add(-large.poll());
        if (large.size() < small.size())
            large.add(-small.poll());
    }

    public double findMedian() {
        if(large.size() == 0 || small.size() == 0) return 0.0;
        return large.size() > small.size()
                ? large.peek()
                : (large.peek() - small.peek()) / 2.0;
    }
}