package facade.demo1;

/**
 * @author LeeMJ
 * @Date 2021 - 11 - 04 - 23:54
 */
public class Test {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.doA();
        facade.doB();
        facade.doC();
    }
}
