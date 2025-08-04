package redis;

import redis.clients.jedis.Jedis;

import java.util.List;

public class JedisDemo1 {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        String ping = jedis.ping();
        System.out.println(ping);

        String set = jedis.set("kkk1", "hello");
        System.out.println(set);

        String mset = jedis.mset("k1", "v1", "k2", "v2");
        System.out.println(mset);
        List<String> mget = jedis.mget("k1", "k2");
        for (String s : mget) {
            System.out.println(s);
        }

        long lpush = jedis.lpush("ll1", "a", "world", "c");
        System.out.println(lpush);
        jedis.lpush("ll1", "apple");
        List<String> ll1 = jedis.lrange("ll1", 0, -1);
        System.out.println(ll1);
    }

}
