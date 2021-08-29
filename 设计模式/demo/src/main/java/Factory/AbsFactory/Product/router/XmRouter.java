package Factory.AbsFactory.Product.router;

/**
 * 路由器具体产品: 小米路由器
 */
public class XmRouter implements IRouter{

    @Override
    public void openWifif() {
        System.out.println("小米路由器开启wifi");
    }
}

