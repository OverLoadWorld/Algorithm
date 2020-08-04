package jvm.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: ZhaoZhenHua1 Administrator
 * @Date: 2020/7/3 15:00
 * -Xmx9m -Xms9m -XX:+PrintGCDetails
 */
public class GCTest {
    public static void main(String[] args) {
/*         final int MAXIMUM_CAPACITY = 1 << 30;
        System.out.println(MAXIMUM_CAPACITY);*/
/*        int i = 0;
        try {
            List<String> list = new ArrayList<>();
            String a = "love";
            while (true) {
                list.add(a);
                a = a + a;
                i++;
            }
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("cishu:" + i);
        }*/
/*        StringBuilder t = new StringBuilder();
        t.append("a").append(System.getProperty("line.separator"));
        t.append("b").append("\r\n");
        t.append("c").append(System.getProperty("line.separator"));
        System.out.println(t);*/

/*        i |= (i >>  1);   18 10010; (i >>  1) 01001; 10010 | 01001 = 11011    27      前2位是1
        i |= (i >>  2);     27 11011; (i >>  2) 00110; 11011 | 00110 = 11110    30      前4位是1
        i |= (i >>  4);     30 11110; (i >>  4) 00001; 11110 | 00001 = 11111    31      全是1
        i |= (i >>  8);
        i |= (i >> 16);
        return i - (i >>> 1);  31 11111 >>> 1 无符号右移1位   01111  11111 - 01111 = 10000        */

/*        System.out.println(Integer.highestOneBit(0));
        System.out.println(Integer.highestOneBit(1));
        System.out.println(Integer.highestOneBit(2));
        System.out.println(Integer.highestOneBit(3));
        System.out.println(Integer.highestOneBit(4));
        System.out.println(Integer.highestOneBit(10));
        System.out.println(Integer.highestOneBit(16));
        System.out.println(Integer.highestOneBit(18));*/

    }
}
