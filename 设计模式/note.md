# a.类之间的关系

```
类与类之间的关系主要分为以下几种:
	泛化；
	实现；
	依赖；
	关联；
	聚合；
	组合；
```

```
泛化:
	描述继承的关系被称为UML中的术语 泛化；
	当一个类表示多个类的共享特征时，称为泛化，例如animal是Dog,Cat的泛化；
```

```
实现:
	面向对象编程中类的接口实现在uml术语中称为 实现;
```

```
依赖:
	一个类中的某个方法如参中使用到了另一个类，称为依赖;
```

```
关联：
	分为两种: 聚合 和 组合;
```

```
聚合:
	体现的是包含关系，一个类在逻辑上包含另一个类，但是被包含的类又可以脱离于第一个类生存;
```

```
组合：
	体现的也是包含关系，但是被包含的类不能脱离于主类生存;
```



# b.设计原则

```
单一指责原则；
开闭原则；
里氏替换原则；
接口隔离原则；
依赖倒置原则;
```

```
单一指责原则:
	不要存在于多于一个导致类变更的原因；通俗地说就是一个类只负责一项职责;
	例子:类T负责两个不同的职责P1和P2。当职责P1需求变更导致要修改类T时，有可能破坏T2的功能;
```

```
开闭原则：
	对扩展开放，对修改关闭;
	最重要的一个原则.
```

```
里氏替换原则:
	子类必须完全可替代其父类；(父类对象出现的地方完全可以由子类对象替代,反之不行)
```

```
接口隔离原则:
	客户端不应依赖于它不需要的接口；
	类之间的关系应建立于最小的接口上；
	通俗的说，就是一个接口的方法应服务于一个功能，不应该把不同功能的方法放在同一个接口中；
		例如类A要实现功能P1，接口I中有两个功能P1和P2的声明，类A可以实现接口I来实现功能P1，但同时也必须被迫实现	   功能P2，但功能P2是不需要的；
```

```
依赖倒置原则:
	高级模块不应该依赖于低级模块，两者都应该依赖抽象；
	抽象不应依赖于细节，细节应依赖于抽象;
```

```
迪米特法则:
	也称为最少知识原则。
	一个对象应该对其他对象有最少的了解。一个类应该对自己需要耦合或调用的类知道得最少。
```



# 1.单例模式

## 1.1概念

```
让一个类只能有一个对象，称为单例模式。

单例模式的使用场景:
	确保某个类的实例对象只能有一个，例如计算机系统中，打印机驱动，显卡驱动，
	数据库连接池，线程池等。
```

```java

/***
 * 懒汉式加载
 * 当需要这个实例的时候，调用该类的getInstance()方法来获得实例；
 * 通过构造方法私有化来避免外部通过new的方式生成对象;
 * 缺点:
 *  线程不安全
 */
public class Singleton1 {

    private static Singleton1 singleton1;

    private Singleton1(){}

    public static Singleton1 getInstance(){
        if( singleton1 == null ){
            singleton1 = new Singleton1();
        }
        return singleton1;
    }

    /**
     * 在多线程情况下，假设两个线程同时调用 getInstance() 方法，
     * 第一个线程判断还没有对象(singleton为null),就会立即调用构造器具生成对象，
     * 而此时第二个线程判断 if( singleton == null )， 如果此时刚好第一个线程还没完成生成对象，
     * 那么第二个线程会判断对象为null,第二个线程也会调用构造器生成对象,那么就出现了两个对象。
     * 这种情况出现的概率虽然小,但是当实例化这个对象所需时间较长，就很有可能发声。
     */
}

/**
 * 懒汉式+同步方法
 * 为了解决懒汉式加载的线程不安全问题，
 * 可以在 getInstance() 方法上加 synchronized关键字把这个方法同步
 * 缺点：效率太低, 同步方法getInstance()在第一次获取对象的时候调用就行了，
 *      之后该对象已经存在，无需再调用 同步方法getInstance()，只需直接返回对象
 *      因为多线程调用同步方法效率很低。
 */
public class Singleton2{

    private static Singleton2 singleton2;

    private Singleton2(){}

    public static synchronized Singleton2 getInstance(){
        if( singleton2 == null ){
            singleton2 = new Singleton2();
        }
        return singleton2;
    }

}

/**
 * 懒汉式+同步代码块
 * 由于懒汉式+同步方法效率太低,所以先判断 if( singleton == null )
 * 之后再进入同步代码块生成对象
 * 缺点:
 *      线程不安全。
 *      加入第一个线程刚刚通过了 if( singleton3 == null )，
 *      还未来得及往下执行，第二个线程也通过了这个判断语句，那么就生成了多个实例。
 *
 */
public class Singleton3{
    private static Singleton3 singleton3;

    private Singleton3(){}

    public static Singleton3 getInstance(){
        if( singleton3 == null ){
            synchronized (Singleton3.class){
                singleton3 = new Singleton3();
            }
        }
        return singleton3;
    }
}


/**
 * 双重检查
 * 针对 懒汉式+同步代码块的线程不安全问题，在new 实例之前再加一步判断
 */
public class Singleton4{

    private static Singleton4 singleton4;

    private Singleton4(){}

    public static Singleton4 getInstance(){
        if( null == singleton4 ){
            synchronized (Singleton4.class){
                if( null == singleton4 ){
                    singleton4 = new Singleton4();
                }
            }
        }
        return singleton4;
    }

}

/**
 * 饿汉式(静态常量)
 * 在类装载的时候完成实例化，避免了线程安全问题
 * 类里的静态常量 singleton5 在加载类的时候就生成。
 *
 * 缺点:
 *  若从未使用过这个实例，则会造成浪费。拖延程序启动时间
 */
public class Singleton5{

    private static final Singleton5 singleton5 = new Singleton5();

    private Singleton5(){}

    public static Singleton5 getInstance(){
        return singleton5;
    }

}

/**
 * 饿汉式(静态代码块)
 * 和饿汉式(静态常量)类似，只不过把生成对象放到了静态代码块中，
 * 达到在装载类时就生成对象
 */
public class Singleton6{

    private static Singleton6 singleton6;

    private Singleton6(){}

    {
        singleton6 = new Singleton6();
    }

    public static Singleton6 getInstance(){
        return singleton6;
    }

}

/**
 *  静态内部类
 *  和饿汉式类似，都是通过JVM加载类的时候初始化静态成员来保证线程安全
 *  但相比于饿汉式的优点: 调用getInstance()方法时才实例化对象，达到了懒加载。
 */
public class Singleton7{

    private Singleton7(){}

    private static class Singleton7Inner{
        private static final Singleton7 singleton7 = new Singleton7();
    }

    public static Singleton7 getInstance(){
        return Singleton7Inner.singleton7;
    }
}

/**
 * 枚举
 * 其他方法都能通过反射破坏单例子，只有枚举不能。
 */
public enum Singleton8{

    INSTANCE;

    public Singleton8 getInstance(){
        return INSTANCE;
    }
}
```

## 1.2单例具体应用

```java
在jdk中的应用:
	java.lang.Runtime;
public class Runtime {
    private static Runtime currentRuntime = new Runtime();

    public static Runtime getRuntime() {
        return currentRuntime;
    }

    private Runtime() {}
  
}
```

```
spring中使用 “单例注册表”来实现单例模式。
```



# 2.工厂模式

## 2.1简单工厂模式

```
简单工厂模式,又称为静态工厂模式,实质是由一个工厂类根据传入的参数，动态决定创建哪一个产品类。
包含以下角色:
	工厂类:负责创建对象的工具类；
	抽象产品:所有产品的(抽象)父类或父接口;
	具体产品：继承或实现抽象产品的类;
	
优点:
	客户端不必关系创建对象的细节，只需知道每一种产品对于所需参数（本例中的“type”）。
缺点:
	扩展性差，一旦有新产品，则必须扩展工厂类的生成产品方法。
```

```java
工厂类:
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
```

```java
抽象产品(可以是抽象父类或接口):
/**
 * 抽象产品接口
 */
interface IProduct{

    String method();

}
```

```java
具体产品:

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

//....
```

## 2.2工厂方法模式

```
 在简单工厂模式的基础上，把工厂也抽象出来.
 每个具体工厂只生产一个特定的具体产品.
 
 角色：
 	抽象工厂；
 	抽象产品；
 	具体工厂；
 	具体产品;
 	
 优点:
 		相比于简单工厂模式，新增产品无需修改工厂类，而是新建一个能生产该新产品的工厂类，符合开闭原则.
 缺点:
 		每一个具体产品类都需要一个具体工厂类，文件变多;
```

```java
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
```

```java
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
```

```java
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

```

```java
测试类:
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
```

```

```



## 2.3抽象工厂模式

```
抽象工厂模式是工厂方法模式的扩展,它不再是创建单一的产品族，而是能创建不同的产品族，也就是抽象产品可以有多个。
工厂方法的工厂类中只有一个方法，这个方法只能生成特定的产品;
而在抽象工厂模式中，对每个抽象产品都有一个生成方法；

角色:
	抽象产品:
		可以有多个,比如所有手机产品的抽象接口 IMobilePhone,所有路由器产品的抽象接口IRouter;
	具体产品类:
		比如: 小米手机，华为手机，小米路由器。华为路由器.
	抽象工厂:
		只有一个，里面有创建不同抽象产品的方法.比如创建手机产品的方法和创建路由器产品的方法；
	具体工厂类：
		用于实现抽象工厂中创建不同产品的方法。
		
优点:
	可以生产多个产品族，而不是生产单一产品族;
缺点:
	再添加新的产品组时，不得不修改抽象工厂，新增一个生产该产品组的方法
	例如添加了新产品族 IScreen, 则IFactory里要添加新方法 IScreen getScreen();
适用场景:
	当需要多个产品族,并且产品族数量相对比较稳定的场景;
	比如: 文本编辑器和图片处理器，分别在Linux下和Windows下的功能是相同的，但代码实现肯定不同，于是我们可以使用抽象工厂模式，产生不同操作系统下的文本编辑器和图片处理器。
```

```java
/**
 * 手机产品抽象
 */
public interface IMobilePhone {
    void call();
}

/**
 * 手机具体产品：华为手机
 */
public class HWPhone implements IMobilePhone{

    @Override
    public void call() {
        System.out.println("华为手机打电话");
    }

}

/**
 * 具体手机：小米手机
 */
public class XMPhone implements IMobilePhone {
    @Override
    public void call() {
        System.out.println("小米手机打电话");
    }
}
```

```java
/**
 * 路由器产品抽象
 */
public interface IRouter {
    void openWifif();
}

/**
 * 路由器具体产品:华为路由器
 */
public class HWRouter implements IRouter {
    @Override
    public void openWifif() {
        System.out.println("华为路由器打开wifi");
    }
}

/**
 * 路由器具体产品: 小米路由器
 */
public class XmRouter implements IRouter{

    @Override
    public void openWifif() {
        System.out.println("小米路由器开启wifi");
    }
}
```

```java
/**
 * 抽象工厂
 */
public interface IFactory {

    IMobilePhone getPhone();

    IRouter getRouter();
}

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
```

## 2.4工厂模式应用

```java
java.util.Calender类中用到了简单工厂模式
Calender类中的方法:
private static Calendar createCalendar(TimeZone zone,
                                           Locale aLocale){
  //...
}

```



# 3.建造者模式

```
当我们需要实力化一个类，可能根据不同是使用场景，有不同的实例化方式(构造方法).
就可以使用不同的类对它们的实例化操作进行封装,这些类就被称为建造者.每当需要来自同一个类但具有不同结构的对象时，就可以通过构造另一个建造者来帮助我们生成这个对象。
```

```
角色:
	抽象产品:需要为其构建对象的类，是具有不同表现形式的复杂对象。
	抽象建造者:用于声明构建产品类的组成部分的抽象类或接口。它的作用是仅公开构建产品类的功能，隐藏其产品类的其他功能。
	具体建造者类:用于实现抽象建造者类接口中声明的方法。
	导演类:用于指导如何构建对象的类。在建造者模式的某些变体中已经移除。
```

