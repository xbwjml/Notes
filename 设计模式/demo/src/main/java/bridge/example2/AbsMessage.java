package bridge.example2;

//抽象消息类
public abstract class AbsMessage {

    //持有一个实现部分的对象
    IMessage message;

    public AbsMessage(IMessage message) {
        this.message = message;
    }

    public void sendMsg(String msg, String toWhom){
        this.message.sendMsg(msg, toWhom);
    }
}
