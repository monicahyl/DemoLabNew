package com.core.training.threadpool;

import java.util.concurrent.*;

/**
 * @Author huangyulu
 * @Date 2025/12/12 17:23
 * @Description 验证ThreadPoolExecutor.AbortPolicy
 */
public class ThreadPoolExecutorAbortPolicyMain {

    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                4, 4, 60, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2),
                new ThreadPoolExecutor.AbortPolicy()
        );

        // 监控线程池状态
//        ScheduledExecutorService monitor = Executors.newSingleThreadScheduledExecutor();
//        monitor.scheduleAtFixedRate(() -> {
//            System.out.println(String.format(
//                    "线程池状态 => 总线程数: %d, 活动线程数: %d, 核心线程数: %d, 最大线程数: %d, 曾创建最大线程数: %d, 已完成任务数: %d, 已提交任务总数: %d, 队列中等待任务数: %d",
//                    pool.getPoolSize(),
//                    pool.getActiveCount(),
//                    pool.getCorePoolSize(),
//                    pool.getMaximumPoolSize(),
//                    pool.getLargestPoolSize(),
//                    pool.getCompletedTaskCount(),
//                    pool.getTaskCount(),
//                    pool.getQueue().size()
//            ));
//        }, 0, 1, TimeUnit.SECONDS); // 每秒打印一次


        for (int i = 1; i <= 10; i++) {
            Runnable01 runnable01 = new Runnable01(i);

            pool.execute(runnable01);


            // 使用execute提交
//            try {
//            pool.execute(runnable01);
//            } catch (RejectedExecutionException e) {
//                System.out.println(e.getMessage());
//            }

            // 使用submit提交
            try {

                Future<String> submit = pool.submit(runnable01, "ok");
            } catch (RejectedExecutionException e) {
            }
        }


        System.out.println("code can be here?");

        // shutdown
        pool.shutdown();
//        monitor.shutdown();
    }
}
