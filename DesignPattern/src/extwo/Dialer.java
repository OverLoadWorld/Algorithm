package extwo;

public class Dialer implements ButtonServer {
    public void enterDigit(int digit) {
        System.out.println("输入号码：" + digit);
    }

    public void dial() {
        System.out.println("拨号中……");
    }

    @Override
    public void buttonPress(int token) {
        enterDigit(token);
    }
}
