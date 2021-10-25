package mediator.example;

public class Stock extends AbsColleague {
    public Stock(AbsMediator mediator) {
        super(mediator);
    }

    private static int NUM = 100;

    public void increase(int num){
        NUM += num;
        System.out.println("库存数量为: "+NUM);
    }

    public void decrease(int num){
        NUM -= num;
        System.out.println("库存数量为: "+NUM);
    }

    public int getNUM(){
        return NUM;
    }

    public void clear(){
        System.out.println("清理库存数量为: "+ NUM);
        super.mediator.execute("stock.clear");
    }
}
