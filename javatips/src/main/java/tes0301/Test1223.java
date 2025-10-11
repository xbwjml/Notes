package tes0301;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RRateLimiter;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.transaction.annotation.Transactional;
import utils.LogUtils;

import java.sql.Array;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

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

public class Test1223 {
    public static void main(String[] args) {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://localhost:6379");
        RedissonClient redissonClient = Redisson.create(config);

        RLock lock = redissonClient.getLock("mytestLock1");
        lock.lock(1000, TimeUnit.MILLISECONDS);

        RRateLimiter limiter = redissonClient.getRateLimiter("test1");
        //limiter.trySetRate();
        //limiter.tryAcquire();
        //limiter.acquire();

        Thread.currentThread().setContextClassLoader();
    }
}

