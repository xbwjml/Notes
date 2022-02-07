package chapter6;

import java.util.concurrent.atomic.AtomicReference;

public class AtomRefTest {
    public  static AtomicReference<User> atomRefUser = new AtomicReference<User>();

    public static void main(String[] args) {
        User user = new User("柯南", 8);
        atomRefUser.set(user);
        User upUser = new User("工藤新一", 17);
        atomRefUser.compareAndSet(user, upUser);
        System.out.println(atomRefUser.get());
    }
}

class User{
    private String name;
    private int old;

    public User(String name, int old) {
        this.name = name;
        this.old = old;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", old=" + old +
                '}';
    }
}
