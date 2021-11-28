package bridge.example2;

//普通消息类
public class NormalMessage extends AbsMessage{
    public NormalMessage(IMessage message) {
        super(message);
    }

    @Override
    public void sendMsg(String msg, String toWhom){
        super.sendMsg(msg, toWhom);
    }
}
