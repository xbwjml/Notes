package Factory.AbsFactory.factory;

import Factory.AbsFactory.Product.phone.HWPhone;
import Factory.AbsFactory.Product.phone.IMobilePhone;
import Factory.AbsFactory.Product.router.HWRouter;
import Factory.AbsFactory.Product.router.IRouter;

/**
 * 具体工厂:华为工厂
 */
public class HWFactory implements IFactory {
    @Override
    public IMobilePhone getPhone() {
        return new HWPhone();
    }

    @Override
    public IRouter getRouter() {
        return new HWRouter();
    }
}
