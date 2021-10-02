package buildMode.staticInnerClass;


public class Car {
    private String brand;
    private String color;
    private String power;

    Car(String brand, String color, String power) {
        this.brand = brand;
        this.color = color;
        this.power = power;
    }

    public static Car.CarBuilder builder() {
        return new Car.CarBuilder();
    }

    public static class CarBuilder {
        private String brand;
        private String color;
        private String power;

        CarBuilder() {
        }

        public Car.CarBuilder brand(String brand) {
            this.brand = brand;
            return this;
        }

        public Car.CarBuilder color(String color) {
            this.color = color;
            return this;
        }

        public Car.CarBuilder power(String power) {
            this.power = power;
            return this;
        }

        public Car build() {
            return new Car(this.brand, this.color, this.power);
        }

        public String toString() {
            return "Car.CarBuilder(brand=" + this.brand + ", color=" + this.color + ", power=" + this.power + ")";
        }
    }
}
