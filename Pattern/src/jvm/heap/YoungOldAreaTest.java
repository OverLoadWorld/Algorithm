package jvm.heap;

/**
 * -Xmx60m -Xms60m -XX:NewRatio=2 -XX:SurvivorRatio=8 -XX:+PrintGCDetails
 * eden : old = 1 : 2
 * young = 20M Old = 40M
 * eden : survivor = 8 : 1
 * eden = 16M  s1 = 2M  s2 = 2M
 * 直接进入老年代
 * ParOldGen       total 40960K, used 20480K [0x00000000fc400000, 0x00000000fec00000, 0x00000000fec00000)
 *   object space 40960K, 50% used [0x00000000fc400000,0x00000000fd800010,0x00000000fec00000)
 */
public class YoungOldAreaTest {
    public static void main(String[] args) {
        byte[] buffer = new byte[1024 * 1024 * 20];
    }
}
