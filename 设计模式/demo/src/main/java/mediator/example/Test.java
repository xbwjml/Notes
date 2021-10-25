package mediator.example;

public class Test {
    public static void main(String[] args) {
        AbsMediator meditor = new Meditor();
        System.out.println("===========采购电脑");
        Purchase purchase = new Purchase(meditor);
        purchase.buy(100);
        System.out.println("=========销售电脑");
        Sale sale = new Sale(meditor);
        sale.sell(1);
        System.out.println("=========清库存");
        Stock stock = new Stock(meditor);
        stock.clear();
    }
}
