package state.example2;

import lombok.Setter;

@Setter
public abstract class UserState {

    protected AppContext context;

    public abstract void favorite();

    public abstract void comment(String comment);
}
