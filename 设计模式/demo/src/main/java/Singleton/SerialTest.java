package Singleton;

import java.io.Serializable;

public class SerialTest implements Serializable {

    public static final SerialTest instance = new SerialTest();
    private SerialTest() {}

    public static SerialTest getInstance() {
        return instance;
    }

    private Object readResolve() {
        return instance;
    }
}
