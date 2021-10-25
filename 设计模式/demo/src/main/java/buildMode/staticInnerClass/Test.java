package buildMode.staticInnerClass;

public class Test {
    public static void main(String[] args) {
        Car car = Car.builder()
                    .color("红色")
                    .power("220马力")
                    .brand("五菱")
                    .build();
        return;
    }
}
