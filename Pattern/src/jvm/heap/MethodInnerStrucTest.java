package jvm.heap;

import java.io.Serializable;

public class MethodInnerStrucTest extends Object implements Comparable<String>, Serializable {

    public int num = 1;
    private static String string = "naizi";

    public void test1() {
        int t = 10;
        System.out.println(t + "as");
    }


    public static int test2(int cal) {
        int tsa = 0;
        try {
            int v = 30;
            tsa = v / cal;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tsa;
    }


    @Override
    public int compareTo(String o) {
        return 0;
    }
}
