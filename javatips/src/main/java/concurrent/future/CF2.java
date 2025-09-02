package concurrent.future;

import concurrent.threadDemo.SleepUtils;
import utils.LogUtils;

import java.util.concurrent.CompletableFuture;

public class CF2 {
    public static void main(String[] args) {
        LogUtils.log("食客进入餐厅");
        LogUtils.log("食客点菜");

        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            LogUtils.log("厨师开始炒菜");
            SleepUtils.second(5);
            LogUtils.log("厨师炒菜好了");
            return "番茄炒蛋";
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            LogUtils.log("开始蒸饭");
            SleepUtils.second(3);
            LogUtils.log("饭蒸好了");
            return "米饭";
        }) , (dish, rice) -> {
            LogUtils.log("开始端菜,打饭");
            SleepUtils.second(1);
            return dish + ",  " + rice + "上桌了";
        });

        LogUtils.log("食客在打游戏等待");
        LogUtils.log(cf1.join() + ", 食客开吃");
    }
}
