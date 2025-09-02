package concurrent.future;

import concurrent.threadDemo.SleepUtils;
import lombok.AllArgsConstructor;
import utils.LogUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.IntFunction;

@AllArgsConstructor
class Serv {
    String url;
    int delay;
    boolean active;
}

public class CF6 {
    public static void main(String[] args) {
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            var s = "111";
            LogUtils.log(s);
            SleepUtils.second(17);
            LogUtils.log(s + " ...");
            return s;
        }).orTimeout(5, TimeUnit.SECONDS);

        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(() -> {
            var s = "222";
            LogUtils.log(s);
            SleepUtils.second(12);
            LogUtils.log(s + " ...");
            //int a = 1/0;
            return s;
        }).orTimeout(5, TimeUnit.SECONDS);

        CompletableFuture<String> cf3 = CompletableFuture.supplyAsync(() -> {
            var s = "333";
            LogUtils.log(s);
            SleepUtils.second(13);
            LogUtils.log(s + " ...");
            return s;
        }).orTimeout(5, TimeUnit.SECONDS);

        CompletableFuture<String>[] arr = new CompletableFuture[3];
        arr[0] = cf1;
        arr[1] = cf2;
        arr[2] = cf3;

        List<Serv> list = new ArrayList<>();
        list.add(new Serv("url1", 4, false));
        list.add(new Serv("url2", 3, false));
        list.add(new Serv("url3", 2, false));

        //list.stream().map(e ->
        //        CompletableFuture.supplyAsync(() -> {
        //            LogUtils.log("开始查询 : " + e.url);
        //            SleepUtils.second(e.delay);
        //            LogUtils.log("查询完毕 : " + e.url);
        //            return e.active;
        //        })
        //).toList()


        //CompletableFuture.allOf(cf1, cf2, cf3).join();
        Object res = CompletableFuture.anyOf(arr)
                .exceptionally(e -> {
                    LogUtils.log(e);
                    return "默认值";
                })
                .join();
        LogUtils.log("=======");
        LogUtils.log(res);
    }
}
