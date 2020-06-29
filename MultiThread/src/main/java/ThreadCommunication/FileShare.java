package ThreadCommunication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @Description:
 * @Author: ZhaoZhenHua1 Administrator
 * @Date: 2020/6/29 15:20
 */
public class FileShare {

    public static void main(String[] args) {
        new Thread(() ->{
            try {
                while (true) {
                    Files.write(Paths.get("demo.log"),
                            ("time:" + String.valueOf(System.currentTimeMillis())).getBytes());
                    Thread.sleep(1000L);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                while (true) {
                    Thread.sleep(1000L);
                    byte[] allBytes = Files.readAllBytes(Paths.get("demo.log"));
                    System.out.println(new String(allBytes));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
