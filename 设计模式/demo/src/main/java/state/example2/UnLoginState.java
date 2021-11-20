package state.example2;

public class UnLoginState extends UserState {

    private void switchLgin(){
        System.out.println("跳转到登录界面");
        this.context.setCurrState(this.context.STATE_LOGIN);
    }


    @Override
    public void favorite() {

    }

    @Override
    public void comment(String comment) {

    }
}
