package build.traditional;

/**
 * 苹果电脑建造者类
 */
public class MacComputerBuilder extends ComputerBuilder{

    private Computer computer;

    public MacComputerBuilder() {
        computer = new Computer();
    }

    @Override
    public Computer getComputer() {
        return computer;
    }

    @Override
    public void setCpu() {
        computer.setCpu("苹果定制intel CPU");
    }

    @Override
    public void setRam() {
        computer.setRam("苹果定制内存");
    }

    @Override
    public void setKeyboard() {
        computer.setKeyboard("magic keyboard");
    }
}
