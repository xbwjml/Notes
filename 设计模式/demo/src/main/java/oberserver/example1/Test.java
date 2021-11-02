package oberserver.example1;

/**
 * @author LeeMJ
 * @Date 2021 - 11 - 03 - 0:06
 */
public class Test {
    public static void main(String[] args) {
        //被观察者
        ISubject<String> observerable = new ConcreteSubject();
        //观察者
        IObserver<String> observer = new ConcreteObserver();
        //注册
        observerable.attach(observer);
        //通知
        observerable.notify("开饭了");
    }
}
