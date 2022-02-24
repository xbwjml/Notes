package pattern.jdkProxy;

public class Zhangsan implements IPerson{

    @Override
    public String eat() {
        String s = "吃面条";
        System.out.println(s);
        return s;
    }

    @Override
    public String drink() {
        String s = "喝可乐";
        System.out.println(s);
        return s;
    }
}
