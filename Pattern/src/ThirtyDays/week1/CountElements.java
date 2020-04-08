package ThirtyDays.week1;

public class CountElements {

    public static void main(String[] args) {
        int nums[] = new int[]{1,2,3};
        int nums1[] = new int[]{1,1,3,3,5,5,7,7};
        int nums2[] = new int[]{1,3,2,3,5,0};
        int nums3[] = new int[]{1,1,2,2};
        System.out.println(countElements(nums));
        System.out.println(countElements(nums1));
        System.out.println(countElements(nums2));
        System.out.println(countElements(nums3));
    }

    /**
     * Runtime: 0 ms
     * Memory Usage: 37.1 MB
     * @param arr
     * @return
     */
    public static int countElements(int[] arr) {
        int counter = 0;
        int nums[] = new int[1001];
        for (int i = 0; i < arr.length; i++) {
            nums[arr[i]]++;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > 0) {
                counter += nums[i];
            }
        }
        return counter;
    }
}
