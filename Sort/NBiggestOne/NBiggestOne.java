package NBiggestOne;

import QuickSort.QuickSort;

/**
 * @Description:
 * @Author: ZhaoZhenHua1 howard
 * @Date: 19-2-14 下午7:31
 */
public class NBiggestOne {
    public static void main(String[] args) {
        int[] a = {6,3,8,1,9,7,2};
        System.out.println(findNBiggest(a, 7));
    }

    private static int findNBiggest(int[] a, int n) {
        return find(a, 0, a.length - 1, n);
    }

    private static int find(int[] a, int start, int end, int n) {
        int pIndex = partition(a, start, end);
        if (pIndex + 1 == n) {
            return a[pIndex];
        } else if (pIndex + 1 > n) {
            return find(a, start, pIndex - 1, n);
        } else {
            return find(a, pIndex + 1, end, n);
        }
    }

    private static int partition(int[] a, int start, int end) {
        int p = a[end];
        int i = start, j = start;
        for (; j <= end; j++) {
            if (a[j] < p) {
                int t = a[j];
                a[j] = a[i];
                a[i] = t;
                i++;
            }
        }
        int t = a[i];
        a[i] = p;
        a[end] = t;
        return i;
    }
}
