package pattern.jdkProxy;

public class MainTest {
    public static void main(String[] args) {
        MP mp = new MP();
        IPerson zs = mp.getInstance(new Zhangsan());
        zs.eat();
        zs.drink();
    }
}
