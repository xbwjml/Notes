package build.traditional;

/**
 * 指导者类
 */
public class Director {

    public void makeComputer(ComputerBuilder builder){
        builder.setCpu();
        builder.setRam();
        builder.setKeyboard();
    }
}
