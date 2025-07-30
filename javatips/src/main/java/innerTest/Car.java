package innerTest;

public class Car {

    private String name;
    int age;
    public String color;
    private int a = 10;

    public void show() {
        System.out.println(name);
        Engine e = new Engine();
        //外部类访问内部类的成员,必须创建对象
        System.out.println(e.engineName);
    }

    public Engine getEngineINs() {
        return new Engine();
    }

     class Engine {
        String engineName;
        int engineAge;
        static String number;
        private int a = 20;

        public void show() {
            System.out.println(engineName);
            //内部类可以直接访问外部类的成员,包括private的
            System.out.println(name);
            System.out.println(age);

            int a = 30;
            System.out.println(a);
            System.out.println(this.a);
            System.out.println(Car.this.a);
        }
    }
}
