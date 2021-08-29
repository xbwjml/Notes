package Factory.AbsFactory.factory;

import Factory.AbsFactory.Product.phone.IMobilePhone;
import Factory.AbsFactory.Product.phone.XMPhone;
import Factory.AbsFactory.Product.router.IRouter;
import Factory.AbsFactory.Product.router.XmRouter;

/**
 * 具体工厂：小米工厂
 */
public class XMFactory implements IFactory {
    @Override
    public IMobilePhone getPhone() {
        return new XMPhone();
    }

    @Override
    public IRouter getRouter() {
        return new XmRouter();
    }
}
