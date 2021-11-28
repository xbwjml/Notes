package bridge.example2;

//实现消息发送的统一接口
public interface IMessage {

    void sendMsg(String msg, String toWhom);
}
