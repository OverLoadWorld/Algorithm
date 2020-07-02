package jvm.heap;

/**
 * @Description:
 * @Author: ZhaoZhenHua1 Administrator
 * @Date: 2020/7/2 15:50
 *
 * -XX:NewRatio=2 默认
 */
public class EdenServivorTest {
    public static void main(String[] args) {
        System.out.println("asdf");
        try {
            Thread.sleep(10000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
