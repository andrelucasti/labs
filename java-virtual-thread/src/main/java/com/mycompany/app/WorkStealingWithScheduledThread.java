package com.mycompany.app;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class WorkStealingWithScheduledThread {
    public static void main(String[] args) throws InterruptedException {

        var scheduledExecutorService = Executors.newScheduledThreadPool(1);

        scheduledExecutorService.scheduleAtFixedRate(() -> {
            ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
            ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
            System.out.println(threadInfos.length + " threads");
        }, 1, 1, TimeUnit.SECONDS);

        Thread.sleep(Duration.ofSeconds(5));

        long startTime = System.currentTimeMillis();
        try {
            try (ExecutorService executorService = Executors.newFixedThreadPool(2)) {
                try (ExecutorService newWorkStealingPool = Executors.newWorkStealingPool(2)) {
                    IntStream.range(0, 10000)
                        .forEach(range -> executorService.submit(() -> {
                            System.out.println("Thread: " + Thread.currentThread().getName());
                            System.out.println("At Thread is :" + range + "processed");
                            newWorkStealingPool.submit(() -> {
                                Thread.sleep(Duration.ofSeconds(1));
                                System.out.println("Worker: " + Thread.currentThread().getName());
                                System.out.println("At worker is :" + range + "processed");


                                return range;

                            });
                        }));
                }
            }
        } catch (Exception e) {
            e.getStackTrace();
        }

        System.out.printf("elapsed time：%d ms", System.currentTimeMillis() - startTime);
    }

}