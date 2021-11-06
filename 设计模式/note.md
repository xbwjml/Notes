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



# 9.责任链模式

```
定义:
	责任链模式将链中的每一个节点都看作一个对象，每个节点处理的请求不同，且在内部维护下一个节点对象。当一个请求从链式的首端发出时，会沿着责任链预设的路径依次传递到每一个节点对象，直至被链中某个节点处理为止。
```

```
角色:
	(1)抽象处理者：定义一个请求处理的方法，并维护下一个处理节点对象的引用。
	(2)具体处理者：对请求进行处理，如果不能处理，则进行转发。
```

```java
public abstract class AbsHandler {
    protected AbsHandler next;

    public void setnext(AbsHandler next){
        this.next = next;
    }

    public abstract void handleRequest(String request);
}

public class HandlerA extends AbsHandler{
    @Override
    public void handleRequest(String request) {
        if ("requestA".equals(request)){
            System.out.println(this.getClass().getSimpleName()+" 处理: "+request);
            return;
        }
        if( null != this.next ){
            this.next.handleRequest(request);
        }
    }
}

public class HandlerB extends AbsHandler {
    @Override
    public void handleRequest(String request) {
        if ("requestB".equals(request)){
            System.out.println(this.getClass().getSimpleName()+" 处理: "+request);
            return;
        }
        if( null != this.next ){
            this.next.handleRequest(request);
        }
    }
}

public class Test {
    public static void main(String[] args) {
        AbsHandler handlerA = new HandlerA();
        AbsHandler handlerB = new HandlerB();
        handlerA.setnext(handlerB);
        handlerA.handleRequest("requestB");
    }
}
```

```
应用:
	Filter
```

```
优点:
	(1)将请求与处理解耦；
	(2)处理者(节点对象)只需关注自己感兴趣的请求进行处理即可，对于不感兴趣的请求，直接转发给下一个节点对象;
	(3)具备链式传递处理请求功能，请求发送者不需要知晓链路结构，只需等待请求处理结果即可；
	(4)链路结构灵活，可以通过改变链路结构动态地新增或删减责任；
	(5)易于扩展新的请求处理类(节点)，符合开闭原则;
缺点:
	(1)责任链太长或处理时间太长，会影响整体性能；
	(2)如果节点对象存在循环引用，则会造成死循环，倒置系统崩溃;
```



# 10.装饰模式

```
定义:
	装饰器模式也叫包装器模式，指不在改变原有对象的基础上，动态地给一个对象添加一些额外职责。就增加新功能来说，装饰器模式相比于生成子类更为灵活。
```

```
	装饰器模式提供了比继承更有弹性的替代方案(扩展原有对象的功能)将功能附加到对象上。因此，装饰器模式的核心是功能扩展。使用装饰器模式可以透明且动态地扩展类的功能。
```

```
应用场景：
	(1)用于扩展一个类的功能，或者给一个类添加附件职责；
	(2)动态地给一个对象添加功能，这些功能可以再动态地被撤销；
	(3)需要为一批平行的兄弟类进行改装或加装功能;
```

```java
例子如下:
public abstract class BatterCake {
    protected abstract String getMsg();
    protected abstract int getPrice();
    @Override
    public String toString() {
        return getMsg()+" 售价 "+getPrice();
    }
}

public class BaseBatterCake extends BatterCake {
    @Override
    protected String getMsg() {
        return "煎饼";
    }

    @Override
    protected int getPrice() {
        return 10;
    }
}
public abstract class Decorator extends BatterCake{
    private BatterCake cake;

    public Decorator(BatterCake cake){
        this.cake = cake;
    }

    @Override
    public String getMsg(){
        return this.cake.getMsg();
    }

    @Override
    public int getPrice(){
        return this.cake.getPrice();
    }
}

public class DecoratorEgg extends Decorator {

    public DecoratorEgg(BatterCake cake) {
        super(cake);
    }

    @Override
    public String getMsg(){
        return super.getMsg()+" +1个鸡蛋";
    }

    @Override
    public int getPrice(){
        return super.getPrice()+1;
    }
}

public class DecoratorSausage extends Decorator {
    public DecoratorSausage(BatterCake cake) {
        super(cake);
    }

    @Override
    public String getMsg(){
        return super.getMsg()+" +1个香肠";
    }

    @Override
    public int getPrice(){
        return super.getPrice()+3;
    }
}

public class Test {
    public static void main(String[] args) {
        BatterCake cake = new BaseBatterCake();
        System.out.println(cake);
        cake = new DecoratorEgg(cake);
        System.out.println(cake);
        cake = new DecoratorEgg(cake);
        System.out.println(cake);
        cake = new DecoratorSausage(cake);
        System.out.println(cake);
        return;
    }
}
```

```
jdk中的应用:
	IO各种流

```

```
优点:
	(1)装饰器模式是继承的有力补充，比继承灵活，在不改变原有对象的情况下，动态地给一个对象扩展功能，即插即用；
	(2)通过使用不同的装饰类及这些装饰类的排列组合，可以实现不用的效果；
	(3)装饰器完全遵循开闭原则；
缺点:
	(1)会出现更多的类；
	(2)动态装饰在多层装饰时会更复杂；
```



# 11.策略模式

```
定义:
	策略模式将定义的算法家族分别封装起来，让它们之间可以互相替换，从而让算法的变化不会影响到使用算法的用户。
	策略模式使用的就是面向对象的继承和多态机制，从而实现同一行为在不同场景下具备不同的实现。
```

```
应用场景:
	策略模式可以解决在有多种相似算法的情况下使用 if else 或 switch case 带来的臃肿性。
	(1)针对同一类型的问题，有多种处理方式。每一种都能独立解决问题；
	(2)需要自由切换算法的场景；
	(3)需要屏蔽算法规则的场景;
```

```
角色:
	(1)上下文角色(Context):用来操作策略的上下文环境，屏蔽高层模块对策略或算法的直接访问，封装可能存在的变化;
	(2)抽象策略角色(IStrategy):规定策略或算法行为;
	(3)具体策略角色(ConcreteStrategy):具体的业务逻辑或算法实现;
```

```java
/**
 * 上下文角色
 */
public class SellActivity {
    private ISellStrategy strategy;

    public SellActivity(ISellStrategy strategy){
        this.strategy = strategy;
    }

    public void execute(){
        this.strategy.sell();
    }
}

/**
 * 抽象策略角色
 */
public interface ISellStrategy {
    void sell();
}

public class CouponStrategy implements ISellStrategy {
    @Override
    public void sell() {
        System.out.println("使用优惠券抵扣");
    }
}

public class CashStrategy implements ISellStrategy {
    @Override
    public void sell() {
        System.out.println("使用现金");
    }
}

public class GroupStrategy implements ISellStrategy {
    @Override
    public void sell() {
        System.out.println("团购优惠");
    }
}

public class Test {
    public static void main(String[] args) {
        SellActivity ac1 = new SellActivity(new CouponStrategy());
        SellActivity ac2 = new SellActivity(new CashStrategy());
        SellActivity ac3 = new SellActivity(new GroupStrategy());

        ac1.execute();
        ac2.execute();
        ac3.execute();
    }
}
```

```
在jdk源码中的应用:
	Comparator接口。
	Comparator有很多实现，经常会把Comparator作为参数传到方法中。
```

```
在spring中的应用:
	InstantiationStrategy接口的两个字类:
		SimpleInstantiationStrategy;
			CglibSubclassingInstantiationStrategy;
```

```
优点:
	(1)算法或实现可以自由切换，避免了臃肿的多重条件判断;
	(2)扩展性良好，增加一个策略，只需增加一个具体策略实现类;
缺点:
	(1)每个策略都是一个类，文件数量变多;
	(2)客户端必须知道所有的策略;
```



# 12.适配器模式

```
定义:
	适配器模式又叫变压器模式，它的功能是将一个类的接口变成客户端所期望的另一种接口，从而使原本因接口不匹配而导致无法在一起工作的两个类能够一起工作。
```

```
使用场景:
	在生活中，适配器模式有非常多应用场景，例如电源转换插头，手机充电转换头，显示器转接头等。
	适配器模式提供一个适配器，将当前系统存在的一个对象转化为客户端能够访问的对象，主要适用于以下场景:
	(1)已存在的类，它的方法和需求不匹配；
	(2)适配器模式不是软件设计阶段考虑的设计模式，是随着软件维护，由于不同产品，不同厂家造成功能类似而接口不同的情况下的解决方案，有亡羊补牢的感觉；
```

```
适配器模式有3种形式:
	类适配器，对象适配器，接口适配器
```

```Javaj a
角色:
	(1)目标角色(ITarget):也就是我们期望的接口;
	(2)源角色(Adaptee):存在于系统中，是指内容满足客户需求(需转换)但接口不匹配的接口实例；
	(3)适配器(Adapter):将Adaptee 转换为 ITarget
```

```
  
```



# 13.迭代器模式

```
定义:
	迭代器模式又叫游标模式，它提供一种按顺序访问集合的方法，而又无需暴露集合的内部表示。迭代器模式可以为不同的容器提供一致的遍历行为，而不用关心容器内元素的组成结构。
```

```
正常开发中基本不需要自己写，源码或框架中基本都有了
	比如jdk中的 java.util.Iterator
```



# 14.组合模式

```
定义:
	组合模式又叫做整体-部分模式，它的宗旨是通过将单个对象(叶子结点)和组合对象(树枝节点)用相同的接口进行表示，使得客户对单个对象和组合对象的使用具有一致性。
```

```
	生活中，组合模式很常见，比如：树形菜单，公司组织架构，文件目录结构等。
```

```
透明组合模式:
	把公共方法都定义在Component中，这样做的好处是客户端无须分辨叶子结点和树枝节点，它们具备完全一致的接口。
```

```
安全组合模式:
	安全组合模式只规定系统各个层次的最基础的一致行为，而把组合(节点)本身的方法(管理子类对象的添加，删除等)放到自身中。
```



# 15.观察者模式

```
定义:
	观察者模式又叫发布订阅模式，定义一种一对多的依赖关系，一个主题对象可被多个观察者对象同时监听，使得每个主题对象状态变化时，所有依赖它的对象都会得到通知并被自动更新。
```

```
	观察者模式的核心是将观察者与被观察者解耦，以类似消息广播发送的机制联动两者，使被观察者的变动能通知到感兴趣的观察者们，从而做出相应的响应。
```

```
	观察者模式主要包含4个角色:
1.抽象主题(ISubject):是被观察的对象，定义了增加,删除,通知观察者对象的方法。
2.具体主题(ConcreteSunject):具体被观察者类，当其内部状态变化时，会通知已注册的观察者。
3.抽象观察者(IObserver):定义了响应通知的更新方法。
4.具体观察者(ConcreteObserver):当得到状态更新的通知时，会自动做出响应。
```

```java
public interface IObserver<E> {
    void update(E event);
}
```

```java
public interface ISubject<E> {

    boolean attach(IObserver<E> observer);

    boolean detach(IObserver<E> observer);

    void notify(E event);
}
```

```java
public class ConcreteObserver<E> implements IObserver<E> {
    @Override
    public void update(E event) {
        System.out.println("收到事件: "+event);
    }
}
```

```java
public class ConcreteSubject<E> implements ISubject<E> {
    private List<IObserver<E>> observers = new ArrayList();

    @Override
    public boolean attach(IObserver<E> observer) {
        return !this.observers.contains(observer) && this.observers.add(observer);
    }

    @Override
    public boolean detach(IObserver<E> observer) {
        return this.observers.remove(observer);
    }

    @Override
    public void notify(E event) {
        this.observers.forEach(e->{
            e.update(event);
        });
    }
}
```

```java
public class Test {
    public static void main(String[] args) {
        //被观察者
        ISubject<String> observerable = new ConcreteSubject();
        //观察者
        IObserver<String> observer = new ConcreteObserver();
        //注册
        observerable.attach(observer);
        //通知
        observerable.notify("开饭了");
    }
}
```



# 16.门面模式

```
定义:
	门面模式又叫做外观模式，提供了一个统一的接口，用来访问子系统中的一系列接口，其主要特征是定义了一个高层接口，让子系统更容易使用。
```

```
应用场景:
	1.为一个复杂的模块或子系统提供一个简洁的供外界访问的接口。
	2.希望提高子系统的独立性。
	3.当子系统由于不可避免的原因导致可能存在的bug或性能相关问题时,可以通过门面模式提供一个高层接口，隔离客户端与子系统的直接交互，防止代码污染。
```

```
角色:
	1.外观角色(Facade):也叫做门面角色，是系统对外的统一接口。
	2.子系统角色(SubSystem)：可以同时拥有一个或多个SubSystem。每个SubSystem都不是一个单独的类，而实一个类的集合。SubSystem并不知道Facade的存在，对于SubSystem而言，Facade只是另一个客户端而已。
```



# 17.备忘录模式

```
定义:
	备忘录模式又叫做快照模式或令牌模式。指在不破坏封装的前提下，捕获一个对象的内部状态，并在对象之外保存这个状态。这样以后就可以将该对象恢复到原先保存的状态。
```

```java
//发起人角色
@Data
public class Originator {
    private String state;

    public Memento createMemento(){
        return new Memento(this.state);
    }

    public void restoreMemento(Memento memento){
        this.setState(memento.getState());
    }
}
```

```java
//备忘录角色
@Data
public class Memento {
    private String state;

    public Memento(String state){
        this.state = state;
    }
}
```

```java
//备忘录管理者角色
public class CreateTaker {
    private Memento memento;

    public Memento getMemento(){
        return this.memento;
    }

    public void storeMemento(Memento memento){
        this.memento = memento;
    }
}

```

```java
public class Test {
    public static void main(String[] args) {
        //创建发起人角色
        Originator originator = new Originator();
        //创建备忘录管理员角色
        CreateTaker createTaker = new CreateTaker();
        //管理员存储发起人的备忘录
        createTaker.storeMemento(originator.createMemento());
        //发起人从管理员获取备忘录进行回滚
        originator.restoreMemento(createTaker.getMemento());
    }
}
```

```
角色:
	1.发起人角色(Originator):负责创建一个备忘录，记录自身需要保存的状态，具备状态回滚功能。
	2.备忘录角色(Memento):用于存储Originator状态，且可防止Originator以外的对象进行访问。
	3.备忘录管理员角色(Caretaker):负责存储，提供管理Memento,无法对Memento的内容进行操作和访问。
```

