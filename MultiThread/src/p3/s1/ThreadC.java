package p3.s1;

public class ThreadC extends Thread {
    private C r;

    public ThreadC(C r) {
        this.r = r;
    }

    @Override
    public void run() {
        while (true) {
            r.getValue();
        }
    }
}
