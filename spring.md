### 1.ApplicationContext和BeanFactory区别

```
ApplicationContext:
	它在构建核心容器时，创建对象采取的策略是采用立即加载的方式。也就是说，只要一读取完配置文件马上就创建配置文件中配置的对象。(单例对象适用)
	
BeanFactory:
	它在构建核心容器时，创建对象采取的策略是采用延迟加载的方式。也就是说，也就是说，什么时候根据id获取对象了，什么时候才正真创建对象。(多例对象适用)
```



### 2.创建Bean的三种方式

```
第一种方式:
	使用默认的构造函数创建.在spring的配置文件中使用bean标签，配置id和class以后，且没有其他属性标签时，采用的就是默认构造函数创建bean对象，如果此类中没有默认构造函数，则对象无法创建。
<bean id="" class="" />

第二种方式:
	使用普通工厂类中的方法创建对象。id配要得到的对象的类型，factory-bean配工厂类,factory-method配该工厂类中产生实例对象的方法.
<bean id="" faactory-bean="" factory-method="" />	

第三种方式:
	使用工厂类中的静态方法创建对象。
<bean id="" class="com.xx.factory" factory-method="staticMethod" />
```



### 3.bean作用范围

```
bean标签的scope属性l
<bean ... scope="" />

scope四个值:
	1.singleton: 默认就是singleton,单例的。
	2.prototype: 多例。
	3.request:	 作用于web应用的请求范围。
	4.session:   作用于web应用的会话范围。
	5.global-session: 作用于集群环境的会话范围(全局会话范围)。当非集群环境时，就是session。    
```



### 3.bean生命周期

```
单例对象；
	出生:当容器创建时出生。
	活着:只要容器在，对象就一直活着。
	死亡:容器销毁,对象消亡。
	总结:单例对象的生命周期和容器相同。

多例对象:
	出生:当我们使用对象时spring框架为我们创建.
	活着:对象只要是在使用过程中就一直活着。
	死亡:由Java GC 来决定。
```



### 4.依赖注入方式

```
1.构造方法注入
2.set方法注入
3.注解注入
```

