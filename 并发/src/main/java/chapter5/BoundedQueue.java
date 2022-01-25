package chapter5;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedQueue<T> {
    private Object[] items;

    private int addIndex, removeIndex, count;

    private Lock lock = new ReentrantLock();

    private Condition notEmpty = lock.newCondition();

    private Condition notFull = lock.newCondition();

    public BoundedQueue(int size){
        items = new Object[size];
    }

    //添加一个元素，如果数组已满，则添加线程进入等待状态，直到有空位
    public void add(T t) throws InterruptedException{
        lock.lock();
        try {
            while (count == items.length)
                notFull.await();

            items[addIndex] = t;

            if(++addIndex == items.length )
                addIndex = 0;

            ++count;
            notEmpty.signal();
        }finally {
            lock.unlock();
        }
    }

    //由头部删除一个元素,若数组元素为空，则删除线程进入等待状态，直到有新元素添加进来
    public T remove() throws InterruptedException{
        lock.lock();
        try {
            while (count == 0)
                notEmpty.await();

            Object x = items[removeIndex];

            if(++removeIndex == items.length)
                removeIndex = 0;

            --count;
            notFull.signal();
            return  (T)x;
        }finally {
            lock.unlock();
        }
    }

}
