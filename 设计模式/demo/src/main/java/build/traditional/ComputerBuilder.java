package build.traditional;

/**
 * 抽象建造者类
 */
public abstract class ComputerBuilder {

    public abstract Computer getComputer();

    public abstract void setCpu() ;
    public abstract void setRam() ;
    public abstract void setKeyboard() ;

}
