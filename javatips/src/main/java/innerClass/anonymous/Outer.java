package innerClass.anonymous;

public class Outer {

    public void say(){
        method(new Car() {
            public void drive() {
                System.out.println("驾驶");
            }
        });
    }

    static void method(Car car){
        car.drive();
    }
}

interface Car{
    void drive();
}
