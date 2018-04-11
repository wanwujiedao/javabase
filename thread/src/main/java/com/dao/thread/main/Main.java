package com.dao.thread.main;

import com.dao.thread.core.MyCallable;
import com.dao.thread.core.MyRunnable;
import com.dao.thread.core.MyThread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 主程序入口
 *
 * @author 阿导
 * @version 1.0
 * @fileName com.dao.thead.main.Main.java
 * @CopyRright (c) 2018-万物皆导
 * @created 2018-04-11 13:47:00
 */
public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
      //启动继承 Thread  类的线程
      new MyThread().start();

      //启动实现 Runnable 接口的线程
      new Thread(new MyRunnable()).start();

      //使用 FutureTask 获取实现 Callable 的线程
      FutureTask<String> task=new FutureTask<String>(new MyCallable());
      //将任务放入线程执行，实质上还是以 Callable 对象来创建并启动线程
      new Thread(task,"测试带返回值的线程").start();
      //查看线程返回值，get() 方法会阻塞，直到子线程执行结束才返回
      System.out.println("带回来的结果:"+task.get());

    }
}
