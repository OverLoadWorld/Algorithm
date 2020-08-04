package jvm.heap;

import java.util.concurrent.locks.ReentrantLock;

/**
 * -Xms60m
 * @Description:
 * @Author: ZhaoZhenHua1 Administrator
 * @Date: 2020/7/3 18:41
 */
public class YoungOldAreaTest {
    public static void main(String[] args) {
        byte[] buffer = new byte[1024 * 1024 * 20];
        ReentrantLock t = new ReentrantLock();
        t.lock();
        t.unlock();
    }
}
