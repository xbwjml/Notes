package oberserver.example1;

/**
 * @author LeeMJ
 * @Date 2021 - 11 - 02 - 23:51
 */
public interface IObserver<E> {
    void update(E event);
}
