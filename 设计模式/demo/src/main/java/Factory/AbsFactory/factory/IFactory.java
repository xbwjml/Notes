package Factory.AbsFactory.factory;

import Factory.AbsFactory.Product.phone.IMobilePhone;
import Factory.AbsFactory.Product.router.IRouter;

/**
 * 抽象工厂
 */
public interface IFactory {

    IMobilePhone getPhone();

    IRouter getRouter();
}
