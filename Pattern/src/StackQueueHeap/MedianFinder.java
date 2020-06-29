package StackQueueHeap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Description:
 * @Author: ZhaoZhenHua1 Administrator
 * @Date: 2020/6/29 12:40
 * Runtime: 46 ms, faster than 75.42% of Java online submissions for Find Median from Data Stream.
 * Memory Usage: 51 MB, less than 33.02% of Java online submissions for Find Median from Data Stream.
 */
public class MedianFinder {
    private PriorityQueue<Integer> maxHeapHalf;
    private PriorityQueue<Integer> minHeapHalf;

    /** initialize your data structure here. */
    public MedianFinder() {
        maxHeapHalf = new PriorityQueue<>(Comparator.reverseOrder());
        minHeapHalf = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (maxHeapHalf.size() == minHeapHalf.size()) {
            if (maxHeapHalf.isEmpty() ||num <= maxHeapHalf.peek()) {
                maxHeapHalf.add(num);
            } else {
                minHeapHalf.add(num);
            }
        } else if (maxHeapHalf.size() > minHeapHalf.size()) {
            if (num <= maxHeapHalf.peek()) {
                //先加，后poll
                maxHeapHalf.add(num);
                minHeapHalf.add(maxHeapHalf.poll());
            } else {
                minHeapHalf.add(num);
            }
        } else {
            if (num <= maxHeapHalf.peek()) {
                maxHeapHalf.add(num);
            } else {
                //先加，后poll
                minHeapHalf.add(num);
                maxHeapHalf.add(minHeapHalf.poll());

            }
        }
    }

    public double findMedian() {
        if (maxHeapHalf.size() == minHeapHalf.size()) {
            int maxHalfPeek = maxHeapHalf.peek() == null ? 0 : maxHeapHalf.peek();
            int minHalfPeek = minHeapHalf.peek() == null ? 0 : minHeapHalf.peek();
            return (double) (maxHalfPeek + minHalfPeek) / 2;
        } else if (maxHeapHalf.size() > minHeapHalf.size()) {
            return (double) (maxHeapHalf.peek() == null ? 0 : maxHeapHalf.peek());
        } else {
            return (double) (minHeapHalf.peek() == null ? 0 : minHeapHalf.peek());
        }
    }

    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        System.out.println(obj.findMedian());
        obj.addNum(12);
        System.out.println(obj.findMedian());
        obj.addNum(10);
        System.out.println(obj.findMedian());
        obj.addNum(13);
        System.out.println(obj.findMedian());
        obj.addNum(11);
        System.out.println(obj.findMedian());
        obj.addNum(5);
        System.out.println(obj.findMedian());//%%
        obj.addNum(15);
        System.out.println(obj.findMedian());
        obj.addNum(1);
        System.out.println(obj.findMedian());
        obj.addNum(11);
        System.out.println(obj.findMedian());
        obj.addNum(6);
        System.out.println(obj.findMedian());
        obj.addNum(17);
        System.out.println(obj.findMedian());
        obj.addNum(14);
        System.out.println(obj.findMedian());
        obj.addNum(8);
        System.out.println(obj.findMedian());
        obj.addNum(17);
        System.out.println(obj.findMedian());
        obj.addNum(6);
        System.out.println(obj.findMedian());
        obj.addNum(4);
        System.out.println(obj.findMedian());
        obj.addNum(16);
        System.out.println(obj.findMedian());
        obj.addNum(8);
        System.out.println(obj.findMedian());
        obj.addNum(10);
        System.out.println(obj.findMedian());
        obj.addNum(2);
        System.out.println(obj.findMedian());
        obj.addNum(12);
        System.out.println(obj.findMedian());
        obj.addNum(0);
        System.out.println(obj.findMedian());
    }
}
