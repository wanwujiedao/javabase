package com.dao.threadpool.main;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * 主程序入口
 *
 * @author 阿导
 * @version 1.0
 * @fileName com.dao.threadpool.main.Main.java
 * @CopyRright (c) 2018-万物皆导
 * @created 2018-04-11 14:57:00
 */
public class Main {

    public static void main(String[] args){
        testThreadPool();
    }

    private static void testThreadPool(){
        //创建同步线程
        final CountDownLatch countDownLatch = new CountDownLatch(10);

        //创建线程名称，方便通过 java visualVM 或者 jconsole 进行监控
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("dao-pool-%d").build();

        //创建线程池，核心线程5个，允许最大线程10个，空闲的多余线程最大存活时间为0L,当前时间单位为毫秒
        ExecutorService pool = new ThreadPoolExecutor(5, 10,0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        for(int i=0;i<1000;i++){
            int a=i;
            pool.execute(()->{
                try {
                    System.out.println("当前count:"+a);
                    Thread.sleep(100);
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        //关闭线程池
        pool.shutdown();
    }

}
