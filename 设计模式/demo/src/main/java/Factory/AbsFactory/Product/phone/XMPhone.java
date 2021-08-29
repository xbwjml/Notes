package Factory.AbsFactory.Product.phone;

/**
 * 具体手机：小米手机
 */
public class XMPhone implements IMobilePhone {
    @Override
    public void call() {
        System.out.println("小米手机打电话");
    }
}
