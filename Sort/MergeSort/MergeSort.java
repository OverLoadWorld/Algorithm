package MergeSort;

/**
 * @Description:
 * @Author: ZhaoZhenHua1 howard
 * @Date: 19-2-13 上午10:12
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] a = {3,2,1,4,56,32,1,5,6,44,74};
        soutArray(a);
        sMergeSort(a);
        soutArray(a);
    }

    private static void sMergeSort(int[] a) {
        int start = 0, end = a.length - 1;
        mergeSort(a, start, end);
    }

    private static void mergeSort(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }
        int middle = (start + end) / 2;
        mergeSort(a, start, middle);
        mergeSort(a, middle + 1, end);
        merge(a, start, middle, end);
    }

    private static void merge(int[] a, int start, int middle, int end) {
        int[] temp = new int[end - start + 1];
        int i = start, j = middle + 1, k = 0;
        while (i <= middle && j <= end) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }

        if (i > middle) {
            while (j <= end) {
                temp[k++] = a[j++];
            }
        }

        if (j > end) {
            while (i <= middle) {
                temp[k++] = a[i++];
            }
        }

        for (int l = 0; l < temp.length; l++) {
            a[start + l] = temp[l];
        }
    }

    private static void soutArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int i1 = a[i];
            System.out.print(i1 + " ");
        }
        System.out.println();
    }
}
