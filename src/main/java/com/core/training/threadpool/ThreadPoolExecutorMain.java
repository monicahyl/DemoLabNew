package com.core.training.threadpool;

import java.util.concurrent.*;

/**
 * @Author huangyulu
 * @Date 2025/12/10 19:06
 * @Description 线程池拒绝策略验证
 */
public class ThreadPoolExecutorMain {

    public static void main(String[] args) {

        // ThreadPoolExecutor.AbortPolicy：直接抛异常RejectedExecutionException
        // 如果不捕获异常，会发生什么？-> 不捕获异常，main线程被异常中断，执行不到pool.shutdown()这行代码，线程池没有被关闭，JVM不会退出

        // ThreadPoolExecutor.CallerRunsPolicy：让调用线程自己去执行任务
        // 实际执行，可以看到打印的结果，阻塞的任务由main线程执行

        // ThreadPoolExecutor.DiscardPolicy：直接丢弃任务，不抛异常
        // ThreadPoolExecutor.DiscardOldestPolicy：丢弃队列最老的任务，再尝试执行新的任务
        // 实际执行可以看到,丢弃的任务是不一样的


        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                4, 4, 60, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2),
//                new ThreadPoolExecutor.CallerRunsPolicy() // 拒绝策略
                new ThreadPoolExecutor.AbortPolicy()
//                new ThreadPoolExecutor.DiscardPolicy()
//                new ThreadPoolExecutor.DiscardOldestPolicy()
        );

        // 监控线程池状态
        ScheduledExecutorService monitor = Executors.newSingleThreadScheduledExecutor();
        monitor.scheduleAtFixedRate(() -> {
            System.out.println(String.format(
                    "线程池状态 => 总线程数: %d, 活动线程数: %d, 核心线程数: %d, 最大线程数: %d, 曾创建最大线程数: %d, 已完成任务数: %d, 已提交任务总数: %d, 队列中等待任务数: %d",
                    pool.getPoolSize(),
                    pool.getActiveCount(),
                    pool.getCorePoolSize(),
                    pool.getMaximumPoolSize(),
                    pool.getLargestPoolSize(),
                    pool.getCompletedTaskCount(),
                    pool.getTaskCount(),
                    pool.getQueue().size()
            ));
        }, 0, 1, TimeUnit.SECONDS); // 每秒打印一次


        for (int i = 1; i <= 10; i++) {
            Runnable01 runnable01 = new Runnable01(i);

            // 使用execute提交
//            try {
//            pool.execute(runnable01);
//            } catch (RejectedExecutionException e) {
//                System.out.println(e.getMessage());
//            }

            // 使用submit提交
            Future<String> submit = pool.submit(runnable01, "ok");
        }


        // shutdown
        pool.shutdown();
        monitor.shutdown();




//        for (int i = 1; i <= 10; i++) {
//            int taskId = i;
//            pool.execute(() -> {
//                System.out.println(Thread.currentThread().getName() + " running task " + taskId);
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                }
//
//            });
//
//
//        }
//
//        System.out.println("当前线程池中线程总数" + pool.getPoolSize());
//        System.out.println("当前正在执行任务的线程数量" + pool.getActiveCount());
//        System.out.println("核心线程数" + pool.getCorePoolSize());
//        System.out.println("最大线程数" + pool.getMaximumPoolSize());
//        System.out.println("线程池曾经创建的最大线程数" + pool.getLargestPoolSize());
//        System.out.println("已完成的任务数" + pool.getCompletedTaskCount());
//        System.out.println("已提交的任务总数（包括未完成和未完成）" + pool.getTaskCount());
//        System.out.println("队列里的等待的任务数" + pool.getQueue().size());


    }
}
