public class BubbleSort{
    public static void BubbleSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            boolean hasSwap = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                int i1 = array[j];
                int i2 = array[j + 1];
                if (i1 > i2) {
                    array[j] = i2;
                    array[j + 1] = i1;
                    hasSwap = true;
                }
            }
            if (!hasSwap) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {0,1,2,3,51,1};
        soutArray(a);
        BubbleSort(a);
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