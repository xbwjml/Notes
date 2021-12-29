package chapter3;

import java.util.concurrent.locks.ReentrantLock;

public class LockExa {
    int a = 0;
    ReentrantLock lock = new ReentrantLock();

    public void writer(){
        lock.lock();
        try {
            a++;
        }finally {
            lock.unlock();
        }
    }

    public void reader(){
        try {
            int i = a;
        }finally {
            lock.unlock();
        }
    }
}
