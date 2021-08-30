package build.traditional;

/**
 * 联想电脑建造者类
 */
public class LenvoComputerBuilder extends ComputerBuilder {

    private Computer computer;

    public LenvoComputerBuilder() {
        computer = new Computer();
    }

    @Override
    public Computer getComputer() {
        return computer;
    }

    @Override
    public void setCpu() {
        computer.setCpu("联想CPU");
    }

    @Override
    public void setRam() {
        computer.setRam("联想ram");
    }

    @Override
    public void setKeyboard() {
        computer.setKeyboard("联想键盘");
    }
}
