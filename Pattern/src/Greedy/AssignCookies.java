package Greedy;

import java.util.Arrays;

/**
 * @Description:
 * @Author: ZhaoZhenHua1 Administrator
 * @Date: 2020/6/29 14:16
 *
 * Runtime: 6 ms, faster than 99.94% of Java online submissions for Assign Cookies.
 * Memory Usage: 40.4 MB, less than 43.29% of Java online submissions for Assign Cookies.
 */
public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        int contentNum = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;
        for (; i < g.length; i++) {
            int childGreed = g[i];
            for (; j < s.length; j++) {
                int cookieSize = s[j];
                if (cookieSize >= childGreed) {
                    contentNum++;
                    j++;
                    break;
                }
            }
        }
        return contentNum;
    }

    public static void main(String[] args) {
        AssignCookies assignCookies = new AssignCookies();

/*        int[] g = new int[]{1,2,3};
        int[] s = new int[]{1,1};*/
/*        int[] g = new int[]{1,2};
        int[] s = new int[]{1,2,3};*/
        int[] g = new int[]{5, 10, 2, 9, 15 ,9};
        int[] s = new int[]{6,1,20,3,8};
        System.out.println(assignCookies.findContentChildren(g, s));
    }
}
