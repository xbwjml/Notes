package redis.phone;

import redis.JedisDemo1;
import redis.clients.jedis.Jedis;
import utils.LogUtils;

import java.util.Random;

public class PhoneCode {
    public static void main(String[] args) {
        generateCode("15912345678");

        //verifyRedisCode("15912345678", "527021");
    }

    public static void verifyRedisCode(String phone, String code) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        String codeKey = "验证:" + phone + ":code";
        String redisCode = jedis.get(codeKey);
        if (redisCode.equals(code))
            LogUtils.log("验证成功: " + code);
        else
            LogUtils.log("验证失败: " + code);
        jedis.close();
    }

    public static void generateCode(String phone) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        String countKey = "验证:" + phone + ":count";
        String count = jedis.get(countKey);
        if (count == null) {
            jedis.setex(countKey, 24 * 60 * 60, "1");
        } else if (Integer.parseInt(count) <= 2) {
            jedis.incr(countKey);
        } else if (Integer.parseInt(count) > 2) {
            LogUtils.log("今天的发送次数已经达到上限");
            jedis.close();
            return;
        }

        String codeKey = "验证:" + phone + ":code";
        String vCode = getCode();
        jedis.setex(codeKey, 120, vCode);
        jedis.close();
    }

    static String getCode() {
        Random random = new Random();
        String code = "";
        for (int i = 0; i < 6; i++)
            code += random.nextInt(10);
        return code;
    }
}
