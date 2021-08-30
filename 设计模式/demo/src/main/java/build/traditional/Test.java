package build.traditional;

public class Test {
    public static void main(String[] args) {
        
        Director director = new Director();

        ComputerBuilder macBuilder = new MacComputerBuilder();
        director.makeComputer(macBuilder);
        Computer macComputer = macBuilder.getComputer();

        ComputerBuilder lenvoBuilder = new LenvoComputerBuilder();
        director.makeComputer(lenvoBuilder);
        Computer lenvoComputer = lenvoBuilder.getComputer();

        return;
    }
}
