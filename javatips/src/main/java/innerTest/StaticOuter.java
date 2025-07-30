package innerTest;

public class StaticOuter {

    String name;
    int age = 10;
    static int age2 = 20;

    static class Inner {
        String innerName;
        int innerAge;

        public void show1() {
            System.out.println("非静态方法调用了");
        }
        public static void show2() {
            System.out.println("静态方法调用了");
        }
    }
}
