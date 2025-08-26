package innerTest;

public class JubuOuter {
    int b = 100;

    public void show() {
        int a = 10;
        class Inner {
            String name = "hello";
            public void show1() {
                System.out.println(b);
                System.out.println(a);
                System.out.println("非静态方法调用了");
            }
            //public static void show2() {
            //    System.out.println("静态方法调用了");
            //}
        }

        Inner innerObj = new Inner();
        System.out.println(innerObj.name);
        innerObj.show1();
        //innerObj.show2();
        //Inner.show2();

    }
}
