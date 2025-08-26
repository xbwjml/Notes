package tes0301;


import concurrent.ThreadPool;
import concurrent.threadDemo.InterruptTest;
import concurrent.threadDemo.SleepUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.java.Log;
import utils.LogUtils;

import java.io.StringReader;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;

class FFaa {
    static {
        System.out.println("父类 static 代码块");
    }
    {
        System.out.println("父类 构造 代码块");
    }

    public FFaa() {
        System.out.println("父类构造方法");
    }
}

class SSonn extends FFaa {
    static {
        System.out.println("子类 static 代码块");
    }
    {
        System.out.println("子类 构造 代码块");
    }
    public SSonn() {
        System.out.println("子类构造方法");
    }
}

class Ts1 {
    int a = 0;
    public int getA() {
        return a;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

@AllArgsConstructor
@Getter
class Ur {
    String name;
    volatile int age;
}

class MyPool extends ThreadPoolExecutor {

    public MyPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
    }
}

public class Test1223 {

    public static void main(String[] args) {



    }
}
