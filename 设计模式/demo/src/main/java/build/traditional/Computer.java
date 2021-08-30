package build.traditional;

/**
 * 产品类
 */
public class Computer {
    private String cpu;
    private String ram;
    private String keyboard;

    public Computer() { }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public void setKeyboard(String keyboard) {
        this.keyboard = keyboard;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", ram='" + ram + '\'' +
                ", keyboard='" + keyboard + '\'' +
                '}';
    }
}
