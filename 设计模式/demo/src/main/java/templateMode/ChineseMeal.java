package templateMode;

public class ChineseMeal extends AbsClass {
    @Override
    protected void buy() {
        System.out.println("买肉丝");
    }

    @Override
    protected void cook() {
        System.out.println("炒鱼香肉丝");
    }

    @Override
    protected void eat() {
        System.out.println("用筷子吃");
    }
}
