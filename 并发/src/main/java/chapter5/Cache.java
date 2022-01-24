package chapter5;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Cache {
    static Map<String, Object> map = new HashMap();
    static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    static Lock r = rwl.readLock();
    static Lock w = rwl.writeLock();

    //读取
    public static final Object get(String key){
        r.lock();
        try {
            return map.getOrDefault(key, null);
        } finally {
            r.unlock();
        }
    }

    //写入
    public static final Object put(String key, Object value){
        w.lock();
        try {
            return map.put(key, value);
        } finally {
            w.unlock();
        }
    }

    //清空
    public static final void clear(){
        w.lock();
        try {
            map.clear();
        } finally {
            w.unlock();
        }
    }

}
