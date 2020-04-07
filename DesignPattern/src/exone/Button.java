package exone;

public class Button {
    public static final int SEND_BUTTON = -99;
    private int token;
    private Dialer dialer;

    public Button(int token, Dialer dialer) {
        this.token = token;
        this.dialer = dialer;
    }

    public void press() {
        switch (token) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                dialer.enterDigit(token);
                break;
            case SEND_BUTTON:
                dialer.dial();
                break;
            default:
                throw new UnsupportedOperationException("u a shit gay.");
        }
    }
}
