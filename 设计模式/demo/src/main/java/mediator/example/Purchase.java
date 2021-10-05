package mediator.example;

public class Purchase extends AbsColleague {
    public Purchase(AbsMediator mediator) {
        super(mediator);
    }

    public void buy(int num){
        super.mediator.execute("purchase.buy", num);
    }

    public void refuseBuy(){
        System.out.println("不再采购");
    }
}
