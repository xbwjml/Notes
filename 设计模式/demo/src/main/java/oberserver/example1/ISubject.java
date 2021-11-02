package oberserver.example1;

/**
 * @author LeeMJ
 * @Date 2021 - 11 - 02 - 23:55
 */
public interface ISubject<E> {

    boolean attach(IObserver<E> observer);

    boolean detach(IObserver<E> observer);

    void notify(E event);
}
