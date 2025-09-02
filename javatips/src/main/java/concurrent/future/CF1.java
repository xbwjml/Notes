package concurrent.future;

import concurrent.threadDemo.SleepUtils;
import utils.LogUtils;

import java.util.concurrent.CompletableFuture;

public class CF1 {
    public static void main(String[] args) {
        LogUtils.log("食客进入餐厅");
        LogUtils.log("食客点菜");

        //CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
        //    LogUtils.log("厨师炒菜");
        //    LogUtils.log("服务员上菜");
        //    return "可以吃了. ";
        //});

        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            LogUtils.log("厨师炒菜");
            SleepUtils.second(3);
            return "番茄炒蛋";
        }).thenCompose(v -> CompletableFuture.supplyAsync(() -> {
            LogUtils.log("服务员开始打饭");
            SleepUtils.second(1);
            return v + "   和 米饭";
        }));

        LogUtils.log("食客在打游戏等待");
        LogUtils.log(cf1.join() + ", 食客开吃");
    }
}
