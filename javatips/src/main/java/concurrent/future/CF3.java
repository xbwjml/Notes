package concurrent.future;

import concurrent.threadDemo.SleepUtils;
import utils.LogUtils;

import java.util.concurrent.CompletableFuture;

public class CF3 {
    public static void main(String[] args) {
        LogUtils.log("食客吃完了");
        LogUtils.log("食客付款,要求开票");

        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            LogUtils.log("服务员付款  500元");
            SleepUtils.second(1);
            return 500;
        })
        //.thenApply(money -> {
        .thenApplyAsync(money -> {
            LogUtils.log("服务员开发票, 面额 : " + money);
            SleepUtils.second(2);
            return money + " 元的发票";
        });

        LogUtils.log("食客打游戏等待");
        LogUtils.log("票开好了 : " + cf.join() + ", 回家");
    }
}
