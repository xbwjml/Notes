# 1JUC

## 1.1线程的状态

​				NEW;

​				RUNNABLE;

​				BLOCKED;

​				WAITING;

​				TIMED_WAITING;

​				TERMINATED;

## 1.2Lock接口

## 1.3synchronized

​				一个对象里面如果有多个synchronized方法，某一时刻内，只要一个线程去调用其中的一个synchronized方法，其他线程都只能等待。换句话说，某一时刻内，只有唯一一个线程去访问这些synchronized方法。

​				synchronized锁的是当前对象this,被锁定后，其他线程都不能进入到当前对象的其他synchronized方法。

​				普通方法和同步锁没关系，同一个当前对象可以同时调用普通方法和一个synchronized方法。

​				两个对象的话，就各管各了。



​				所有的非静态同步方法用的都是同一把锁——锁住实例对象本身。	也就是说如果一个实例对象的非静态同步方法获取锁之后，该实例对象的其他非静态同步方法必须等待获取锁的方法释放锁后才能获取锁，所以必须等到该实例对象已获取锁的非静态同步方法释放锁就可以获取他们自己的锁。

​				所有的静态同步方法用的也是同一把锁——锁住类对象本身。	

​				所以静态同步方法和非静态同步方法之间不会竞争。但是一旦一个静态同步方法获取锁之后，其他的静态同步方法都必须等该方法释放锁之后才能获取锁，而不管是同一个实例对象的静态同步方法之间，还是不同的实例对象的静态同步方法之间，只要它们是同一个类的实例对象。



## 1.4Callable接口

​				在主线程中需要执行略耗时的操作时，但又不想阻塞主线程时，可以把这些作业交给Future对象在后台完成，当主线程将来需要时，就可以通过Future对象获得后台作业的计算结果或者执行状态。

​				一般FutureTask多用于耗时的计算，主线程可以在完成自己的任务后，再去获取结果。

​				仅在计算完成时才能检索结果，如果计算尚未完成，则阻塞get方法。一旦计算完成，就不能重新开始或取消计算。get方法而获取结果只有在计算完成时获取，否则会一直阻塞直到任务转入完成状态，然后回返回结果或抛出异常。

​				只计算依次，get方法放到最后。

## 1.5CountDownLatch

​				CountDownLatch主要有两个方法，当一个或多个线程调用await方法时，这些线程会阻塞。其他线程调用countDown()方法会将计数器减1（调用countDown方法的线程不会阻塞）。当计数器的值变为0时，因await方法阻塞的线程会被唤醒，继续执行。







# 2JVM

## 2.1JVM体系结构概述

![JVM位置](java_senior_pic/JVM/JVM位置.png)





​				JVM体系结构概览（如下图所示）：

![JVM体系结构概览](java_senior_pic/JVM/JVM体系结构概览.png)

上图中，灰色的部分不会有垃圾回收；JVM调优就是调橙色的地方，大概率是调整堆。



## 2.2类装载器ClassLoader

​				负责加载class文件，class文件在文件开头有特定的文件标识，并且ClassLoader只是负责class文件的加载，至于它是否可以运行，则由Execution Engine决定。

![类装载器](java_senior_pic/JVM/类装载器.png)



类装载器的顺序如下图所示：

![类装载器顺序](java_senior_pic/JVM/类装载器顺序.png)



## 2.3双亲委派&沙箱

​				待补充

## 2.4执行引擎Execute Engine

​				Execute Engine执行引擎负责解释命令，提交操作系统执行；

## 2.5本地方法接口Native Interface

![native本地接口](java_senior_pic/JVM/native本地接口.png)



## 2.6本地方法区Native Method Stack

![本地方法区](java_senior_pic/JVM/本地方法区.png)



## 2.7PC寄存器

​				又称程序计数器（Program Counter Register ）。

![PC寄存器](java_senior_pic/JVM/PC寄存器.png)



## 2.8方法区Method Area

![方法区](java_senior_pic/JVM/方法区.png)



## 2.9栈

![栈内存](java_senior_pic/JVM/栈内存.png)



​				栈里面存些什么？

![栈存的东西](java_senior_pic/JVM/栈存的东西.png)



​				栈运行原理;

![栈运行原理](java_senior_pic/JVM/栈运行原理.png)



![栈_两个栈帧图解](java_senior_pic/JVM/栈_两个栈帧图解.png)



![栈_栈帧里面](java_senior_pic/JVM/栈_栈帧里面.png)



![栈_堆_方法区的交互关系](java_senior_pic/JVM/栈_堆_方法区的交互关系.png)



## 2.10堆

![堆](java_senior_pic/JVM/堆.png)



![堆_java7之前](java_senior_pic/JVM/堆_java7之前.png)



​				新生区：

![新生区](java_senior_pic/JVM/新生区.png)



![hotSpot内存管理](java_senior_pic/JVM/hotSpot内存管理.png)



![hotSpot_新生代png](java_senior_pic/JVM/hotSpot_新生代png.png)



![hotSpot_旧生代](java_senior_pic/JVM/hotSpot_旧生代.png)



​				永久区：

![永久区](java_senior_pic/JVM/永久区.png)



## 2.11堆内存调优

![堆内存调优java7](java_senior_pic/JVM/堆内存调优java7.png)



![堆内存调优java8](java_senior_pic/JVM/堆内存调优java8.png)



![堆内存调优简介01](java_senior_pic/JVM/堆内存调优简介01.png)





## 2.10 MAT

![MAT简介](java_senior_pic/JVM/MAT简介.png)



