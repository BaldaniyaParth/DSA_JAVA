package Day45;
import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianDataStream {

    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        obj.addNum(2);
        System.out.println("Median: " + obj.findMedian()); // Output: 1.5
        obj.addNum(3);
        System.out.println("Median: " + obj.findMedian());
    }
}

class MedianFinder {
    PriorityQueue<Integer> smallNums; // Max Heap
    PriorityQueue<Integer> largeNums; // Min Heap

    public MedianFinder() {
        smallNums = new PriorityQueue<>(Collections.reverseOrder());
        largeNums = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // Add to maxHeap first (Group of smaller numbers)
        smallNums.offer(num);
        // Balance the heaps
        largeNums.offer(smallNums.poll());
        if (largeNums.size() > smallNums.size()) {
            smallNums.offer(largeNums.poll());
        }
    }

    public double findMedian() {
        if (smallNums.size() != largeNums.size()) {
            return smallNums.peek();
        }
        return (smallNums.peek() + largeNums.peek()) / 2.0;
    }
}