package concurrent.threadDemo;

import lombok.AllArgsConstructor;
import lombok.ToString;
import utils.LogUtils;

import java.util.Deque;
import java.util.LinkedList;

@ToString
@AllArgsConstructor
class Msg {
    private int id;
    private Object val;
}

class MsgQueue {
    private Deque<Msg> queue = new LinkedList<>();
    private int capacity;

    public MsgQueue(int capacity) {
        this.capacity = capacity;
    }

    public Msg take() {
        synchronized (queue) {
            while (queue.isEmpty()) {
                try {
                    LogUtils.log("队列为空, 消费者线程等待");
                    queue.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            Msg msg = queue.removeFirst();
            LogUtils.log("已消费一个消息 : " + msg);
            queue.notifyAll();
            return msg;
        }
    }

    public void put(Msg msg) {
        synchronized (queue) {
            while (queue.size() == capacity) {
                try {
                    LogUtils.log("队列已满, 生产者线程等待");
                    queue.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            queue.addLast(msg);
            LogUtils.log("已生产一个消息 : " + msg);
            queue.notifyAll();
        }
    }
}

public class ProduceConsumeTest {
    public static void main(String[] args) {
        MsgQueue queue = new MsgQueue(2);

        for (int i = 0; i < 3; i++) {
            int id = i;
            new Thread(() -> {
                queue.put(new Msg(id, "值 " + id));
            }, "生产者" + i).start();
        }

        new Thread(() -> {
            while (true) {
                SleepUtils.second(1);
                queue.take();
            }
        }, "消费者").start();
    }
}
