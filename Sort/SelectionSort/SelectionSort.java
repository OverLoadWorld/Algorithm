package SelectionSort;

public class SelectionSort {
    public static void SelectionSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length + 1; j++) {
                if ( array[j - 1] < array[minIndex]) {
                    minIndex = j - 1;
                }
            }
            int t = array[minIndex];
            array[minIndex] = array[i];
            array[i] = t;
        }
    }

    public static void main(String[] args) {
        int[] a = {7,5,6,0,1,2,3,51,1};
        soutArray(a);
        SelectionSort(a);
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