package mediator.example;

public class Meditor extends AbsMediator{
    @Override
    public void execute(String str, Object... objects) {
        if ("purchase.buy".equals(str))
            this.buy((Integer)objects[0]);
        if ("sale.sell".equals(str))
            this.sell((Integer)objects[0]);
        if ("sale.offsale".equals(str))
            this.offSale();
        if ("stock.clear".equals(str))
            this.clear();
    }

    private void buy(int num){
        int saleStatus = super.sale.getSaleStatus();
        if(saleStatus>80){
            System.out.println("采购电脑台数： "+num);
            super.stock.decrease(num);
        }else{
            int buyNum = num/2;
            System.out.println("采购电脑台数： "+buyNum);
        }
    }

    private void sell(int num){
        if( super.stock.getNUM() < num ){
            super.purchase.buy(num);
        }
        super.stock.decrease(num);
    }

    private void offSale(){
        System.out.println("折价销售台数: "+stock.getNUM());
    }

    private void clear(){
        super.sale.offSale();
        super.purchase.refuseBuy();
    }
}
