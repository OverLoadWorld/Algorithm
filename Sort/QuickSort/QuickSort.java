package QuickSort;

/**
 * @Description:
 * @Author: ZhaoZhenHua1 howard
 * @Date: 19-2-14 下午3:39
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] a = {3,7,1,6,5,4};
        soutArray(a);
        sQuickSort(a);
        soutArray(a);
    }

    private static void sQuickSort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    public static void quickSort(int[] a, int head, int tail) {
        if (head >= tail) {
            return;
        }
        //int pivot = partitionRough(a, head, tail);
        int pivot = partition(a, head, tail);
        quickSort(a, head, pivot - 1);
        quickSort(a, pivot + 1, tail);
    }

    public static int partition(int[] a, int head, int tail) {
        int p = a[tail];
        int i = head;
        for (int j = head; j < tail; j++) {
            if (a[j] < p) {
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
                i++;
            }
        }
        int t = a[i];
        a[i] = a[tail];
        a[tail] = t;
        return i;
    }

    private static int partitionRough(int[] a, int head, int tail) {
        int p = a[tail];
        int[] X = new int[a.length];
        int[] Y = new int[a.length];
        int Xi = 0, Yi = 0;
        for (int i = head; i < tail; i++) {
            if (a[i] <= p) {
                X[Xi++] = a[i];
            } else if (a[i] > p) {
                Y[Yi++] = a[i];
            }
        }
        int i = head;
        for (; i < head + Xi; i++) {
            a[i] = X[i - head];
        }
        int ret = i;
        a[i++] = p;
        for (int j = 0; j < Yi; j++) {
            a[i + j] = Y[j];
        }
        return ret;
    }

    private static void soutArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int i1 = a[i];
            System.out.print(i1 + " ");
        }
        System.out.println();
    }
}
