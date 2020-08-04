package jvm.heap;

<<<<<<< HEAD
import java.util.concurrent.locks.ReentrantLock;

/**
 * -Xms60m
 * @Description:
 * @Author: ZhaoZhenHua1 Administrator
 * @Date: 2020/7/3 18:41
=======
/**
 * -Xmx60m -Xms60m -XX:NewRatio=2 -XX:SurvivorRatio=8 -XX:+PrintGCDetails
 * eden : old = 1 : 2
 * young = 20M Old = 40M
 * eden : survivor = 8 : 1
 * eden = 16M  s1 = 2M  s2 = 2M
 * 直接进入老年代
 * ParOldGen       total 40960K, used 20480K [0x00000000fc400000, 0x00000000fec00000, 0x00000000fec00000)
 *   object space 40960K, 50% used [0x00000000fc400000,0x00000000fd800010,0x00000000fec00000)
>>>>>>> 8a2763ccedeb83e953695ef9df7e909b0e4abde6
 */
public class YoungOldAreaTest {
    public static void main(String[] args) {
        byte[] buffer = new byte[1024 * 1024 * 20];
        ReentrantLock t = new ReentrantLock();
        t.lock();
        t.unlock();
    }
}
