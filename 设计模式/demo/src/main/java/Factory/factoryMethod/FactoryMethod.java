package Factory.factoryMethod;

public class FactoryMethod {
    public static void main(String[] args) {

        //要获取apple,先获取AppleFacttory
        IFruitFactory appleFactory = new AppleFacttory();
        IFruit apple = appleFactory.getFruit();

        //要获取banana,先获取BananaFactory
        IFruitFactory bananaFactory = new BananaFactory();
        IFruit banana = bananaFactory.getFruit();

    }
}

/**
 * 抽象产品
 */
interface IFruit{
    String method();
}

/**
 * 抽象工厂
 */
interface IFruitFactory{

    IFruit getFruit();
}

/**
 * 具体苹果产品
 */
class Apple implements IFruit{

    @Override
    public String method() {
        return "我是苹果";
    }
}

/**
 * 具体苹果工厂
 */
class AppleFacttory implements IFruitFactory{

    @Override
    public IFruit getFruit() {
        return new Apple();
    }
}

/**
 * 具体香蕉产品
 */
class Banana implements IFruit{

    @Override
    public String method() {
        return "我是香蕉";
    }
}

/**
 * 具体香蕉工厂
 */
class BananaFactory implements IFruitFactory{

    @Override
    public IFruit getFruit() {
        return new Banana();
    }
}

