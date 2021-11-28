package bridge.example2;

//加急消息类
public class UrgencyMessage extends AbsMessage {
    public UrgencyMessage(IMessage message) {
        super(message);
    }

    @Override
    public void sendMsg(String msg, String toWhom) {
        msg = "加急 " + msg;
        super.sendMsg(msg, toWhom);
    }

}
