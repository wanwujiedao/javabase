package com.dao.datastructure;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author 阿导
 * @version 1.0
 * @fileName com.dao.datastructure.Test.java
 * @CopyRright (c) 2018-万物皆导
 * @created 2018-04-10 17:08:00
 */
public class Test {

    public static void main(String[] args){
//        long startTime= System.currentTimeMillis();//开始时间
//        int threadNumber = 2;
//        final CountDownLatch countDownLatch = new CountDownLatch(threadNumber);
//        new Thread(new Runnable(){
//            public void run(){
//                for(int i=0;i<1000;i++){
//                    System.out.println("A:"+i);
//                }
//                countDownLatch.countDown();
//            }
//        }).start();
//
//        new Thread(new Runnable(){
//            public void run() {
//                for(int j=0;j<1000;j++){
//                    System.out.println("B:"+j);
//                }
//                countDownLatch.countDown();
//            }
//        }).start();
//        try {
//            countDownLatch.await();
//        } catch (InterruptedException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//        System.out.println("执行总时间:"+(System.currentTimeMillis()-startTime));


        //创建线程名称，方便通过 java visualVM 或者 jconsole 进行监控
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("dao-pool-%d").build();

        //创建线程池
        ExecutorService pool = new ThreadPoolExecutor(5, 10,0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        for(int i=0;i<1000;i++){
            int a=i;
            pool.execute(()->{
                try {
                    System.out.println("当前count:"+a);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        pool.shutdown();

    }

}
