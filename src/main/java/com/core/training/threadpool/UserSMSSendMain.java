package com.core.training.threadpool;

import cn.hutool.core.util.IdUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Author huangyulu
 * @Date 2025/12/12 18:01
 * @Description
 */
public class UserSMSSendMain {

    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(5,
                10,
                60, TimeUnit.SECONDS,
                new ArrayBlockingQueue(10),
                new ThreadPoolExecutor.CallerRunsPolicy());

        List<FutureTask<String>> futureTaskList = new ArrayList<>();

        for (int i = 1; i <= 50; i++) {
            UserSMSInfo userSMSInfo = new UserSMSInfo();
            userSMSInfo.setPhoneNumber(IdUtil.randomUUID());
            userSMSInfo.setContent("welcome");

            UserSMSSend userSMSSend = new UserSMSSend(userSMSInfo);
            FutureTask<String> futureTask = new FutureTask<>(userSMSSend);


            pool.submit(futureTask);
            futureTaskList.add(futureTask);
        }

        for (FutureTask futureTask : futureTaskList) {
            try {
                System.out.println(futureTask.get());
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }

        }

        pool.shutdown();


    }
}
