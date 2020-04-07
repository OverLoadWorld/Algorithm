package extwo;

import exone.Dialer;

public class Button implements ButtonServer {
    public static final int SEND_BUTTON = -99;
    private int token;
    private Dialer dialer;

    public Button(int token, Dialer dialer) {
        this.token = token;
        this.dialer = dialer;
    }

    @Override
    public void buttonPress(int token) {

    }
}
