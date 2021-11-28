package bridge.example2;

//邮件消息实现类
public class EmailMessage implements IMessage{
    @Override
    public void sendMsg(String msg, String toWhom) {
        System.out.println("使用邮件发送: "+msg+" 给:  "+toWhom);
    }
}
