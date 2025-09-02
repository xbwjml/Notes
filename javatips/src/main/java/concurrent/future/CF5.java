package concurrent.future;

import utils.LogUtils;

import java.util.concurrent.CompletableFuture;

public class CF5 {
    public static void main(String[] args) {
        CompletableFuture<String> cf =
                CompletableFuture.supplyAsync(() -> {
                    var s = "1111111";
                    LogUtils.log(s);
                    return s;
                })
                .thenApply(v -> {
                    System.out.println(v);
                    var s = "22222222";
                    LogUtils.log(s);
                    int a = 1/0;
                    return s;
                })
                //.handle((a, b) -> {
                //    LogUtils.log(a);
                //    LogUtils.log(b);
                //    LogUtils.log(b.getStackTrace());
                //    return "456";
                //})
                .whenComplete((a, b) -> {
                    LogUtils.log(a);
                    LogUtils.log(b);
                    LogUtils.log(b.getStackTrace());
                    LogUtils.log("----------");
                })
                ;

        cf.join();

    }
}
