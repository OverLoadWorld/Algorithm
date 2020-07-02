package jvm.dynamicLinking;

/**
 * @Description:
 * @Author: ZhaoZhenHua1 Administrator
 * @Date: 2020/6/30 19:28
 */
public class DynamicLinkingTest {

    int t = 10;

    public void methodA() {
        System.out.println("aaaa");
    }

    public void methodB() {
        System.out.println("bbbb");
        methodA();
        t++;
    }
}
