package bridge.example2;

public class Test {
    public static void main(String[] args) {
        IMessage message = new SmsMessage();
        AbsMessage absMessage = new NormalMessage(message);
        absMessage.sendMsg("今日有雨","观众朋友");

        message = new EmailMessage();
        absMessage = new UrgencyMessage(message);
        absMessage.sendMsg("发生山体滑坡", "领导");
    }
}
