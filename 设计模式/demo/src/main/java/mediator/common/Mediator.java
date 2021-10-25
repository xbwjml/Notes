package mediator.common;

import lombok.Setter;

@Setter
public abstract class Mediator {
    protected ColleagueA a;
    protected ColleagueB b;

    public abstract void transferA();
    public abstract void transferB();
}
