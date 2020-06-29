package ThreadCommunication;

/**
 * @Description:
 * @Author: ZhaoZhenHua1 Administrator
 * @Date: 2020/6/29 15:33
 */
public class VariablesShare {

    public static String t = "shit";

    public static void main(String[] args) {
        new Thread(() ->{
            try {
                while (true) {
                    t = "time:" + String.valueOf(System.currentTimeMillis());
                    Thread.sleep(1000L);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                while (true) {
                    Thread.sleep(1000L);
                    System.out.println(t);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
