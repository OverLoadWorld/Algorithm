package p1.daemonThread;

public class Run {
    public static void main(String[] args) throws InterruptedException {
        MyThread thread = new MyThread();
        thread.setDaemon(true);
        thread.start();
        thread.sleep(5000);
        System.out.println("离开了");
    }
}
