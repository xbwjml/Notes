package mediator.example;

import java.util.Random;

public class Sale extends AbsColleague {
    public Sale(AbsMediator mediator) {
        super(mediator);
    }

    public void sell(int num){
        super.mediator.execute("sale.sell", num);
        System.out.println("销售台数： "+num);
    }

    public int getSaleStatus(){
        Random rand = new Random(System.currentTimeMillis());
        int saleStatus = rand.nextInt(100);
        System.out.println("销售情况为: "+saleStatus);
        return saleStatus;
    }

    public void offSale(){
        super.mediator.execute("sale.offSale");
    }
}
