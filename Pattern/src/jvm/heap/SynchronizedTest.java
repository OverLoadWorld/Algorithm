package jvm.heap;

public class SynchronizedTest {
    public void  f() {
        Object t = new Object();
        synchronized (t) {
            System.out.println("shit");
        }

    }
}
