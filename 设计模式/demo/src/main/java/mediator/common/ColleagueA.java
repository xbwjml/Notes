package mediator.common;

public class ColleagueA extends Colleague {
    public ColleagueA(Mediator mediator) {
        super(mediator);
        this.mediator.setA(this);
    }

    public void selfMethodA(){
        System.out.println(this.getClass().getSimpleName()+", selfMethod");
    }

    public void depMethodA(){
        System.out.println(this.getClass().getSimpleName()+", depMethod");
        this.mediator.transferA();
    }
}
