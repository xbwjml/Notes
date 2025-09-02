package com.bio.day4;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class HandlerSockerServerPool {

    private ExecutorService executorService;

    public HandlerSockerServerPool(int maxThreadCount, int queueSize) {
        executorService = new ThreadPoolExecutor(
                3,
                maxThreadCount,
                120,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(queueSize)
        );
    }

    public void execute(Runnable target) {
        executorService.execute(target);
    }
}
