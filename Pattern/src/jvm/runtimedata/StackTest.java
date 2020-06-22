package jvm.runtimedata;

/**
 * @Description:
 * @Author: ZhaoZhenHua1 Administrator
 * @Date: 2020/6/18 19:26
 */
public class StackTest {

    public static void a() {
        int i = 1;
        int j = 2;
        b();
    }

    public static void b() {
        int k = 3;
        int m = 4;
    }

    public static void main(String[] args) {
        a();
    }
}
