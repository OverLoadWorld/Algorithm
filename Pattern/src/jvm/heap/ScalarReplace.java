package jvm.heap;

/**
 * -Xmx100m -Xms100m -XX:+DoEscapeAnalysis -XX:+PrintGC -XX:-EliminateAllocations
 */
public class ScalarReplace {
    public static class User{
        public int id;
        public String name;
    }

    public static void alloc() {
        User u = new User();
        u.id = 5;
        u.name = "shit";
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            alloc();
        }
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

}
