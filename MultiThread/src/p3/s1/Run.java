package p3.s1;

public class Run {
    public static void main(String[] args) {
        String lock = new String("");
        P p = new P(lock);
        C r = new C(lock);

        ThreadP p1 = new ThreadP(p);
        ThreadC c1 = new ThreadC(r);
        p1.start();
        c1.start();
    }
}
