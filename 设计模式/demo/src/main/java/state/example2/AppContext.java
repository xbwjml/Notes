package state.example2;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppContext {
    public static final UserState STATE_LOGIN = new LoginState();
    public static final UserState STATE_UNLOGIN = new UnLoginState();

    private UserState currState = STATE_UNLOGIN;

    {
        STATE_LOGIN.setContext(this);
        STATE_UNLOGIN.setContext(this);
    }

    public void favorite(){
        this.currState.favorite();
    }

    public void comment(String comment){
        this.currState.comment(comment);
    }
}
