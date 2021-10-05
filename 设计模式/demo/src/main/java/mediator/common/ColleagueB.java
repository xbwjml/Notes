package mediator.common;

public class ColleagueB extends Colleague {
    public ColleagueB(Mediator mediator) {
        super(mediator);
        this.mediator.setB(this);
    }

    public void selfMethodB(){
        System.out.println(this.getClass().getSimpleName()+", selfMethod");
    }

    public void depMethodB(){
        System.out.println(this.getClass().getSimpleName()+", depMethod");
        this.mediator.transferB();
    }
}