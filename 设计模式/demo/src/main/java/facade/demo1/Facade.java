package facade.demo1;

/**
 * @author LeeMJ
 * @Date 2021 - 11 - 04 - 23:52
 */
public class Facade {
    SubSystemA a = new SubSystemA();
    SubSystemB b = new SubSystemB();
    SubSystemC c = new SubSystemC();

    public void doA(){
        a.doA();
    }

    public void doB(){
        b.doB();
    }

    public void doC(){
        c.doC();
    }
}
