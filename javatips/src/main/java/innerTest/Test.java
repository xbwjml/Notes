package innerTest;

public class Test {
    public static void main(String[] args) {
        //Car.Engine obj = new Car().new Engine();
        //
        //Car car = new Car();
        //Car.Engine engineINs = car.getEngineINs();
        //System.out.println(engineINs);
        //
        //engineINs.show();

        //StaticOuter.Inner obj = new StaticOuter.Inner();
        //obj.show1();
        //obj.show2();
        //
        //StaticOuter.Inner.show2();

        //new JubuOuter().show();

        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                System.out.println("hello");
            }
        };

        Runnable runnable2 = () -> System.out.println("hello2");

        runnable.run();
        runnable2.run();
    }
}
