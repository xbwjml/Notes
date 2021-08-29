package Factory.AbsFactory.Product.phone;



/**
 * 手机具体产品：华为手机
 */
public class HWPhone implements IMobilePhone{

    @Override
    public void call() {
        System.out.println("华为手机打电话");
    }

}