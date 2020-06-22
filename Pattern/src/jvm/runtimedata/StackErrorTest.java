package jvm.runtimedata;

/**
 * @Description:
 * @Author: ZhaoZhenHua1 Administrator
 * @Date: 2020/6/19 10:50
 */
public class StackErrorTest {
    public static int i = 0;
    public static void main(String[] args) {
        System.out.println(i);
        i++;
        main(args);
    }
}
