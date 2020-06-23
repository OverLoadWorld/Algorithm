package jvm.runtimedata;

/**
 * @Description:
 * @Author: ZhaoZhenHua1 Administrator
 * @Date: 2020/6/18 16:18
 */
public class PCRegisterTest {

    public static void main(String[] args) {
        int i = 10;
        int j = 20;
        int k = i + j;
        String s = "sadf";
        System.out.println(i);
        System.out.println(k);
        new PCRegisterTest().test1();
    }

    public  void test1() {
        System.out.println("shit");
    }

    public  void test2() {
        int a = 0;
        {
            int b = 0;
            b = a + 1;
        }
        int c = a + 1;
    }
}
