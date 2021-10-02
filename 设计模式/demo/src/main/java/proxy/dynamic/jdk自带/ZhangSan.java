package proxy.dynamic.jdk自带;

public class ZhangSan implements IPerson {

    @Override
    public void study() {
        System.out.println("张三在读书");
    }

    @Override
    public void eat() {
        System.out.println("张三在吃饭");
    }
}
