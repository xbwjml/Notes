package oberserver.example1;

/**
 * @author LeeMJ
 * @Date 2021 - 11 - 02 - 23:58
 */
public class ConcreteObserver<E> implements IObserver<E> {
    @Override
    public void update(E event) {
        System.out.println("收到事件: "+event);
    }
}
