package jvm.heap;

public class HeapSpaceInitial {
    public static void main(String[] args) {
        long initialMemory = Runtime.getRuntime().totalMemory() / 1024 /1024;
        long maxMemory = Runtime.getRuntime().maxMemory() / 1024 /1024;
        System.out.println("-Xms:" + initialMemory + "M");
        System.out.println("-Xmx:" + maxMemory + "M");
        /**
         * -Xms:575M
         * -Xmx:575M
         * 设置的600
         * 因为eden区和s区之一才能又数据，所以少了一个s区
         */

//        try {
//            Thread.sleep(1000000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
