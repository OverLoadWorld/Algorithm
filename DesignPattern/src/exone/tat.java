package exone;

public class tat {
    public static void main(String[] args) {
        Dialer dialer = new Dialer();
        Button button = new Button(9, dialer);
        button.press();
        Button button1 = new Button(-99, dialer);
        button1.press();

    }
}
