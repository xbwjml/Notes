package Factory.simpleFactory;

import java.util.Objects;

public class SimpleFactory {
    public static void main(String[] args) {

    }
}

/**
 * 工厂类
 */
class Factory{

    public static IProduct getProduct(String type){

        if(Objects.equals(type, "计算机") )
            return new Computer();

        if(Objects.equals(type, "汽车") )
            return new Car();

        //......

        return null;
    }

}

/**
 * 抽象产品接口
 */
interface IProduct{

    String method();

}


/**
 * 具体的计算机产品类
 */
class Computer implements IProduct{

    @Override
    public String method() {
        return "我是计算机产品";
    }
}

/**
 * 具体的汽车产品类
 */
class Car implements IProduct{

    @Override
    public String method() {
        return "我是汽车产品";
    }
}

