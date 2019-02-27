package BucketSort;

/**
 * @Description:
 * @Author: ZhaoZhenHua1 howard
 * @Date: 19-2-15 下午3:31
 */
public class BucketSort {
    public static void BucketSort(int[] array, int cacheLimit){
        int n = array.length;
        int bucketNum = (int) Math.sqrt(n);
        for (int i = 0; i < bucketNum; i++) {
            
        }
    }

    public static void main(String[] args) {
        int[] a = {0,1,2,3,51,1,0,0,3,2,2,5,5,3,46,33,34,21,15,54};
        soutArray(a);
        BucketSort(a, 6);
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
