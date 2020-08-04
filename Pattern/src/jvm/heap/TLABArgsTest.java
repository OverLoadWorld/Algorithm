package jvm.heap;

/**
 * -XX:UserTLAB 默认开启
 */
public class TLABArgsTest {
    public static void main(String[] args) {
        System.out.println("shit");
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
