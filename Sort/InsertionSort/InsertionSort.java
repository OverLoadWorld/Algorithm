package InsertionSort;

public class InsertionSort {
    public static void InsertionSort(int[] array){
        for (int i = 1; i < array.length; i++) {
            int value = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (array[j] > value){
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = value;
        }
    }

    public static void main(String[] args) {
        int[] a = {7,5,6,0,1,2,3,51,1};
        soutArray(a);
        InsertionSort(a);
        soutArray(a);
    }

    private static void soutArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int i1 = a[i];
            System.out.print(i1 + " ");
        }
        System.out.println();
    }
}