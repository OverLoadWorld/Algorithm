package StackQueueHeap;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Description:
 * @Author: ZhaoZhenHua1 Administrator
 * @Date: 2020/6/24 16:25
 */
public class MaxHeap<T extends Comparable> {

    private T[] data; // 数据存储
    private int count; // 堆目前所含数据量大小
    private int capacity; // 堆容量大小

    public int left(int i) {
        return 2 * i;
    }

    public int right(int i) {
        return 2 * i + 1;
    }

    public int parent(int i) {
        if (i <= 0) {
            return -1;
        }
        return i / 2;
    }

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        this.data = (T[]) new Comparable[capacity + 1];
    }

    public MaxHeap(T[] data, int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity must not be 0");
        }
        if (capacity <= data.length) {
            throw new IllegalArgumentException("capacity must greater than the length of data");
        }
        this.capacity = capacity;
        this.count = data.length;
        buildHeap(data);
    }

    private void buildHeap(T[] array) {
        data = (T[]) new Comparable[capacity];
        this.count =  array.length;
        // 第一个节点空出
        System.arraycopy(array, 0, data, 1, count);
        for (int k = count; k > 0 ; k--) {
            heapUp(k);
        }
    }

    public void add(T value) {
        Objects.requireNonNull(value, "value must not be null");
        if (count >= capacity - 1) {
            return;
        }
        ++count;
        this.data[count] = value;
        heapUp(count);
    }

    public T remove() {
        if (count == 0) {
            return null;
        }
        T value = this.data[1];
        this.data[1] = this.data[this.count];
        this.data[this.count] = null;
        --this.count;

        heapDown(count, 1);
        return value;
    }

    /**
     * 上浮
     */
    private void heapUp(int index) {
        checkPosition(index);
        int nodeIndex = index;
        T value = this.data[nodeIndex];
        if (value == null) {
            return;
        }

        while (nodeIndex > 0 && parent(nodeIndex) >0
                && data[nodeIndex].compareTo(data[parent(nodeIndex)]) > 0) {

            swap(nodeIndex, parent(nodeIndex));
            nodeIndex = parent(nodeIndex);
        }
    }

    /**
     * 下沉
     *
     * @param n 总数量
     * @param i 当前节点位置
     */
    private void heapDown(int n, int i) {
        while (true) {
            int maxPos = i;
            int left = left(i);
            int right = right(i);
            if (left <= n && this.data[i].compareTo(this.data[left]) < 0) {
                maxPos = left;
            }
            if (right <= n && this.data[maxPos].compareTo(this.data[right]) < 0) {
                maxPos = right;
            }
            if (maxPos == i) {
                break;
            }
            swap(i, maxPos);
            i = maxPos;
        }
    }

    private void checkPosition(int index) {
        if (index <= 0 || index > count) {
            throw new IllegalArgumentException("illegal argument index.");
        }
    }

    private void swap(int i, int j) {
        checkPosition(i);
        checkPosition(j);
        T tempValue = this.data[i];
        this.data[i] = this.data[j];
        this.data[j] = tempValue;
    }
}
