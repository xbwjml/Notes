package oberserver.example1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LeeMJ
 * @Date 2021 - 11 - 03 - 0:01
 */
public class ConcreteSubject<E> implements ISubject<E> {
    private List<IObserver<E>> observers = new ArrayList();

    @Override
    public boolean attach(IObserver<E> observer) {
        return !this.observers.contains(observer) && this.observers.add(observer);
    }

    @Override
    public boolean detach(IObserver<E> observer) {
        return this.observers.remove(observer);
    }

    @Override
    public void notify(E event) {
        this.observers.forEach(e->{
            e.update(event);
        });
    }
}
