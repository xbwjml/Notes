package bridge.example2;

//短信消息实现类
public class SmsMessage implements IMessage {
    @Override
    public void sendMsg(String msg, String toWhom) {
        System.out.println("使用短信发送: "+msg+" 给:  "+toWhom);
    }
}
