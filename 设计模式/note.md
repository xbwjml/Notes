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
	一个类中的某个方法入参中使用到了另一个类，称为依赖;
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

```

```



# 3.模板方法模式

```
定义:
	定义一个操作中的算法的框架,而将一些步骤延迟到子类中。使得子类可以不改变一个算法的结构即可重新定义该算法的某些特定步骤。
```

```
模板方法模式的抽象类中分两种方法：
	1.基本方法(由子类去实现);
	2.模板方法，是对基本方法的调用，完成固定的逻辑;
	
	注意:	为了防止恶意调用，模板方法都加上final关键字，不允许被重写。
	
```

```java
public abstract class AbsClass {

    protected abstract void buy();

    protected abstract void cook();

    protected abstract void eat();

    public final void method(){
        this.buy();
        this.cook();
        this.eat();
    }
}
```

```java
public class ChineseMeal extends AbsClass {
    @Override
    protected void buy() {
        System.out.println("买肉丝");
    }

    @Override
    protected void cook() {
        System.out.println("炒鱼香肉丝");
    }

    @Override
    protected void eat() {
        System.out.println("用筷子吃");
    }
}
```

```java
public class FrenchMeal extends AbsClass{
    @Override
    protected void buy() {
        System.out.println("买cheese");
    }

    @Override
    protected void cook() {
        System.out.println("涂抹面包");
    }

    @Override
    protected void eat() {
        System.out.println("上手吃");
    }
}
```

```java
public class Test {
    public static void main(String[] args) {
        AbsClass chineseMeal = new ChineseMeal();
        AbsClass frenchMeal = new FrenchMeal();

        chineseMeal.method();
        frenchMeal.method();
    }
}
```

```
模板方法方法模式的优点:
	封装不变的部分，扩展可变的部分。
	把不变的部分封装到父类实现，把可变的部分交给子类实现。

模板方法模式的缺点:
	按照设计习惯，抽象类负责声明最抽象普遍的属性和方法，子类去实现。而模板方法模式确颠倒了。
```

```
模板方法模式的使用场景:
	多个子类有共有的方法，并且逻辑基本相同时；
	复杂，重要的算法，可以把核心算法设计为模板方法，周边相关的细节方法由子类来实现；
	
```



# 4.建造者模式

```
定义:
	将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。
```

```java
现在更习惯使用静态内部类的方式实现建造者模式：
public class Car {
    private String brand;
    private String color;
    private String power;

    Car(String brand, String color, String power) {
        this.brand = brand;
        this.color = color;
        this.power = power;
    }

    public static Car.CarBuilder builder() {
        return new Car.CarBuilder();
    }

    public static class CarBuilder {
        private String brand;
        private String color;
        private String power;

        CarBuilder() {
        }

        public Car.CarBuilder brand(String brand) {
            this.brand = brand;
            return this;
        }

        public Car.CarBuilder color(String color) {
            this.color = color;
            return this;
        }

        public Car.CarBuilder power(String power) {
            this.power = power;
            return this;
        }

        public Car build() {
            return new Car(this.brand, this.color, this.power);
        }

        public String toString() {
            return "Car.CarBuilder(brand=" + this.brand + ", color=" + this.color + ", power=" + this.power + ")";
        }
    }
}
```

```java
public class Test {
    public static void main(String[] args) {
        Car car = Car.builder()
                    .color("红色")
                    .power("220马力")
                    .brand("五菱")
                    .build();
        return;
    }
}
```

```
建造者模式在jdk中的应用:
	AbstractStringBuilder类实现了 Appendable接口，实现其中的append方法.
```

```
在Mybatis中的应用:
	CacheBuilder类
```

```
在spring中的应用:
	BeanDefinitionBuilder类;
```





# 5.代理模式

```
定义:
	为其他对象提供一种代理以控制对这个对象的访问。
```

```
  在某些情况下，一个对象不能或不合适直接引用另一个对象，而代理对象可以在客户端与目标对象之间起到中介的作用。
  当无法或不想直接引用某个对象，或访问某个对象存在困难时，可以通过代理对象来间接访问。
	使用代理模式主要有两个目的：
		1）保护目标对象；
		2）增强目标对象；
```

```
代理模式一般包含3个角色：
	抽象主题角色(Subject)：主要职责是声明真实主题与代理主题的共同接口方法。
	真实主题角色(RealSubject)：也称为被代理类，定义了代理所表示的真实对象，是负责执行真正逻辑的对象。
	代理主题角色(Proxy)：也称为代理类，其内部持有RealSubject的引用。
```

```
代理模式分为：
	静态代理；
	动态代理；
```

```java
静态代理案例如下:
public interface ISubject {
    void request();
}

public class RealSubject implements ISubject{
    @Override
    public void request() {
        System.out.println("real method called");
    }
}

public class Proxy implements ISubject{

    private ISubject subject;

    public Proxy(ISubject subject){
        this.subject = subject;
    }

    @Override
    public void request() {
        before();
        subject.request();
        after();
    }

    public void before(){
        System.out.println("proxy before");
    }

    public void after(){
        System.out.println("proxy after");
    }
}

public class Client {
    public static void main(String[] args) {
        ISubject subject = new Proxy(new RealSubject());
        subject.request();
    }

}

```

```
静态代理的局限性:
	必须自己写代理类，得知道被代理对象。
```

```
动态代理:
	不需要手动创建代理类,无需关系被代理的对象是谁,只需编写一个动态处理器。
	目前普遍使用的是jdk自带的代理和cglib
```

```java
jdk自带动态代理如下:
需要 java.lang.reflect.InvocationHandler 和 java.lang.reflect.Proxy
jdk动态代理要求被代理的类实现接口

public interface IPerson {

    void study();

    void eat();
}

public class ZhangSan implements IPerson {

    @Override
    public void study() {
        System.out.println("张三在读书");
    }

    @Override
    public void eat() {
        System.out.println("张三在吃饭");
    }
}

public class PersonHandeler implements InvocationHandler {

    private IPerson target;

    public IPerson getInstance(IPerson target){
        this.target = target;
        Class clazz = target.getClass();
        return (IPerson) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object res = method.invoke(this.target, args);
        after();
        return res;
    }

    private void before(){
        System.out.println("前置方法");
    }

    private void after(){
        System.out.println("后置方法");
    }
}

public class Test {
    public static void main(String[] args) {
        PersonHandeler proxy = new PersonHandeler();
        IPerson person = proxy.getInstance(new ZhangSan());
        person.study();
        person.eat();
        return;
    }
}
```

```java
cglib动态代理如下:
被代理的类可以不实现接口.
public class Consumer {

    public void buy(){
        System.out.println("购物中");
    }
}

public class CGlibPro implements MethodInterceptor {

    public Object getInstance(Class clazz) throws Exception{
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object res = methodProxy.invokeSuper(o, objects);
        after();
        return res;
    }

    public void before(){
        System.out.println("前置方法");
    }

    public void after(){
        System.out.println("后置方法");
    }
}

public class Test {
    public static void main(String[] args) throws Exception {
        Consumer consumer = (Consumer) new CGlibPro().getInstance(Consumer.class);
        consumer.buy();
        return;
    }
}
```

```
jdk动态代理和cglib动态代理对比:
	(1)jdk动态代理实现了被代理对象的接口，cglib动态代理继承了被代理对象。
	(2)jdk动态代理和cglib动态代理都在运行时期生成字节码。jdk动态代理直接写class字节码；cglib动态代理使用ASM框架写Class字节码。cglib动态代理实现更复杂，生成代理类比jdk动态代理效率低。
	(3)jdk动态代理调用代理方法是通过反射；cglib动态代理是通过FastClass机制直接调用方法，cglib动态代理的执行效率更高。
```

```

```



# 6.原型模式

```
定义:
	用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象。
```

```
  原型模式的核心在于复制原型对象。以系统中已存在的一个对象为原型，直接基于内存二进制流复制，不需要再经历耗时的对象初始化过程(不调用构造函数)，性能提升许多。
```

```
JDK提供了 Cloneable 接口,继承该接口并实现clone方法即可。
调用clone方法不会走构造函数。
```

```java
@Data
public class ProtoA implements Cloneable{

    private String desc;

    @Override
    public ProtoA clone() {
        ProtoA obj = null;
        try {
            obj = (ProtoA) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
```

```java
super.clone()是浅拷贝，
若类中有引用类型的属性，则只会拷贝该引用类型对象的一个引用；
若要完成深拷贝，则该引用类型的属性也得拷贝，如下所示:

@Data
public class ProtoB implements Cloneable{

    private String desc;

    private ArrayList<String> hobby = new ArrayList();

    public ProtoB(){
        System.out.println("构造方法");
    }

    @Override
    public ProtoB clone() {
        ProtoB obj = null;
        try {
            obj = (ProtoB) super.clone();
            this.hobby = (ArrayList) this.hobby.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return obj;
    }

}
```

```java
也可以实现Serializable接口来实现深拷贝

@Data
public class ProtoB implements Cloneable, Serializable {

    private String desc;

    private ArrayList<String> hobby = new ArrayList();

    public ProtoB(){
        System.out.println("构造方法");
    }

    @Override
    public ProtoB clone() {
        ProtoB obj = null;
        try {
            obj = (ProtoB) super.clone();
            this.hobby = (ArrayList) this.hobby.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return obj;
    }

    public ProtoB deepClone(){
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            return (ProtoB) ois.readObject();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
```

```
在jdk中的应用：
	太多了，不列举，基本实现 Cloneable的类都用到了。
```



# 7.中介者模式

```
定义:
	中介者模式又叫做调解者模式或调停者模式。用一个中介对象封装一系列对象交互，中介者使各个对象不需要显式地相互作用，从而使其耦合松散，而且可以独立地改变它们之间的交互，属于行为设计模式。
	中介者模式包装了一系列对象相互作用的方式，使得这些对象不必相互明显作用，从而使它们可以松散耦合。当某些对象之间的作用发生改变时，不会立即影响其他一些对象之间的作用。保证这些作用可以彼此独立地变化。其核心思想是，通过中介者解耦系统各层次对象的直接耦合，层次对象的对外依赖通信全部交由中介者转发。
```

```
	中介者模式是用来降低多个对象和类之间的通信复杂性的。这种模式通过提供一个中介类，将系统各层次之间的多对多关系变成一对多关系，中介者对象可以将复杂的网状结构变成以中介者为中心的星形结构，达到降低系统复杂性，提高可扩展性的作用。
```

```
角色:
	(1)抽象中介者: 定义统一的接口，用于各个同事角色之间的通信。
	(2)具体中介者: 从具体的同事对象接受消息，向具体同事对象发出命令，协调同事间的协作。
	(3)抽象同事类: 每一个同事对象均需要依赖中介者角色，与其他同事间通信时，交由中介者转发协作。
	(4)具体同事类:	负责实现自发行为，转发依赖方法交由中介者进行协调.
		
```

```java
@Setter
public abstract class Mediator {
    protected ColleagueA a;
    protected ColleagueB b;

    public abstract void transferA();
    public abstract void transferB();
}

public class ConcreteMediator extends Mediator {
    @Override
    public void transferA() {
        this.b.selfMethodB();
    }

    @Override
    public void transferB() {
        this.a.selfMethodA();
    }
}

public abstract class Colleague {
    protected Mediator mediator;
    public Colleague(Mediator mediator){
        this.mediator = mediator;
    }
}

public class ColleagueA extends Colleague {
    public ColleagueA(Mediator mediator) {
        super(mediator);
        this.mediator.setA(this);
    }

    public void selfMethodA(){
        System.out.println(this.getClass().getSimpleName()+", selfMethod");
    }

    public void depMethodA(){
        System.out.println(this.getClass().getSimpleName()+", depMethod");
        this.mediator.transferA();
    }
}

public class ColleagueB extends Colleague {
    public ColleagueB(Mediator mediator) {
        super(mediator);
        this.mediator.setB(this);
    }

    public void selfMethodB(){
        System.out.println(this.getClass().getSimpleName()+", selfMethod");
    }

    public void depMethodB(){
        System.out.println(this.getClass().getSimpleName()+", depMethod");
        this.mediator.transferB();
    }
}

public class Test {
    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();
        ColleagueA a = new ColleagueA(mediator);
        ColleagueB b = new ColleagueB(mediator);
        a.depMethodA();
        b.depMethodB();
    }
}
```

```
优点:
	-减少类之间的依赖，将多对多转换为一对多，降低了类间耦合。
	-类之间各司其职，符合迪米特法则。
缺点:
	-中介者模式将原本多个对象直接的相互依赖变成了中介者和多个同事类的依赖关系。当同事类越多时，中介者就会越来臃肿。
```



# 8.命令模式

```
定义:
	命令模式是对命令的封装，每一个命令都是一个操作：接收方发出请求要求执行一个操作；接收方收到请求，并执行操作。命令模式解耦了请求方与接收方，请求方只需请求执行命令，不用关心命令怎样被接收，怎样操作以及是否被执行等。命令模式属于行为设计模式。
```

```
	在软件系统中，行为请求者与实现者通常是一种紧耦合关系，因为这样的实现简单明了。但紧耦合关系缺乏扩展性，在某些场合中，当需要对行为进行记录，撤销或重做等处理时候，只能修改源码。而命令模式通过在请求与实现之间引入一个抽象命令接口，解耦了请求与实现，并且中间件是抽象的，它由不同的子类实现，因此具备扩展性。所以，命令模式的本质是解耦命令请求与处理。
```

```
主要角色如下:
	(1)接收者 Receievr：该类负责具体执行一个请求。
	(2)抽象命令角色 ICommand：定义需要执行的所有命令行为。
	(3)具体命令角色 ConcreteCommand：该类内部维护一个Receiver,在其execute()方法中调用Receiver的相关方法。
	(4)请求者角色 Invoker:接收客户端的命令，并执行命令。
```

```java
代码如下:

/**
 * 具体Receievr
 */
public class GPlayer {

    public void play(){
        System.out.println("正常播放");
    }

    public void speed(){
        System.out.println("更改播放速度");
    }

    public void stop(){
        System.out.println("终止播放");
    }

    public void pause(){
        System.out.println("暂停");
    }
}
```

```java
/**
 * ICommand
 */
public interface IAction {
    void execute();
}
```

```java
/**
 * 各个ConcrteCommand
 */
public class PlayAction implements IAction {

    private GPlayer player;

    public PlayAction(GPlayer player){
        this.player = player;
    }

    @Override
    public void execute() {
        this.player.play();
    }
}

public class SpeedAction implements IAction {
    private GPlayer player;

    public SpeedAction(GPlayer player){
        this.player = player;
    }

    @Override
    public void execute() {
        this.player.speed();
    }
}

public class PauseAction implements IAction {
    private GPlayer player;

    public PauseAction(GPlayer player){
        this.player = player;
    }

    @Override
    public void execute() {
        this.player.pause();
    }
}

public class StopAction implements IAction {
    private GPlayer player;

    public StopAction(GPlayer player){
        this.player = player;
    }

    @Override
    public void execute() {
        this.player.stop();
    }
}

```

```java
public class Test {
    public static void main(String[] args) {
        GPlayer player = new GPlayer();
        List<IAction> actions = Arrays.asList(
                new PlayAction(player),
                new PauseAction(player),
                new SpeedAction(player),
                new StopAction(player)
        );

        actions.forEach(e->{
            e.execute();
        });
    }
}
```

```
优点:
	(1)通过引入中间件ICommand,解耦了命令的请求与实现；
	(2)扩展性良好，可以很容易增加新命令；
	(3)支持组合命令，支持队列命令；
	(4)可以在现有命令的基础上，增加额外功能。
缺点:
	(1)具体命令可能会很多。
```

