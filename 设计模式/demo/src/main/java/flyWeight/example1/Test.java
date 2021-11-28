package flyWeight.example1;

public class Test {
    public static void main(String[] args) {
        IFlyweight f1 = FkyweightFactory.getFlyweight("aa");
        IFlyweight f2 = FkyweightFactory.getFlyweight("bb");
        f1.operation("a");
        f2.operation("b");
    }
}
