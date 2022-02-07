package chapter6;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomIntFiledUpdaterTest {
    private static AtomicIntegerFieldUpdater<Usera> a =
            AtomicIntegerFieldUpdater.newUpdater(Usera.class, "old");

    public static void main(String[] args) {
        Usera xl = new Usera("小兰", 17);
        System.out.println(a.getAndIncrement(xl));
        System.out.println(a.get(xl));
    }

}

class Usera{
    private String name;
    public volatile int old;

    public Usera(String name, int old) {
        this.name = name;
        this.old = old;
    }

    @Override
    public String toString() {
        return "Usera{" +
                "name='" + name + '\'' +
                ", old=" + old +
                '}';
    }
}
