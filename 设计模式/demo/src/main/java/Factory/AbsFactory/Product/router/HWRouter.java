package Factory.AbsFactory.Product.router;

/**
 * 路由器具体产品:华为路由器
 */
public class HWRouter implements IRouter {
    @Override
    public void openWifif() {
        System.out.println("华为路由器打开wifi");
    }
}
