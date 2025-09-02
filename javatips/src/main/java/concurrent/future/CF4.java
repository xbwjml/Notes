package concurrent.future;

import concurrent.threadDemo.JoinTest;
import concurrent.threadDemo.SleepUtils;
import utils.LogUtils;

import java.util.concurrent.CompletableFuture;

public class CF4 {
    public static void main(String[] args) {
        LogUtils.log("张三走出餐厅,来到公交站");
        LogUtils.log("等待100路或200路公交");

        CompletableFuture<String> busCf = CompletableFuture.supplyAsync(() -> {
                    LogUtils.log("700路 公交车正在赶来");
                    SleepUtils.second(5);
                    return "700路 到了";
                })
                .applyToEither(CompletableFuture.supplyAsync(() -> {
                    LogUtils.log("800路 公交车正在赶来");
                    SleepUtils.second(3);
                    return "800路 到了";
                }), bus -> {
                    LogUtils.log(bus);
                    if (bus.startsWith("800"))
                        throw new RuntimeException("撞树了");
                    return bus;
                })
                .exceptionally(e -> {
                    LogUtils.log(e);
                    LogUtils.log("叫出租车");
                    SleepUtils.second(2);
                    return "出租车到了";
                })
                ;

        LogUtils.log(String.format("%s, 张三上车", busCf.join()));
    }
}
