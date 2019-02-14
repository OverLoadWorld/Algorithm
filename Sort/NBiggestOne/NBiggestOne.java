package NBiggestOne;

import QuickSort.QuickSort;

/**
 * @Description:
 * @Author: ZhaoZhenHua1 howard
 * @Date: 19-2-14 下午7:31
 */
public class NBiggestOne {
    /*public static void main(String[] args) {
        int[] a = {6,3,8,1,9,7,2};
        System.out.println(findNBiggest(a, 0, a.length - 1, 3));
    }

    private static int findNBiggest(int[] a, int start, int end, int N) {
        int p = a[end];
        int i = start;
        for (int j = start; j < end; j++) {
            if (a[j] < p) {
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
                i++;
            }
        }
        int t = a[i];
        a[i] = a[end];
        a[end] = t;

        if (p + 1 == N) {
            return a[p];
        } else if (p + 1 > N) {
            return findNBiggest(a, start, p - 1, N);
        } else {
            return findNBiggest(a, p + 1, end, N);
        }
    }*/
}
