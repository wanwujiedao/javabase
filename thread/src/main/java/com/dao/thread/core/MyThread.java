package com.dao.thread.core;

/**
 * 继承 Thread 类创建线程
 *
 * @author 阿导
 * @version 1.0
 * @fileName com.dao.thead.core.MyThead.java
 * @CopyRright (c) 2018-万物皆导
 * @created 2018-04-11 13:32:00
 */
public class MyThread extends Thread {

    /**
     * 重写 run 方法
     *
     * @author 阿导
     * @time 2018/4/11
     * @CopyRight 万物皆导
     * @param
     * @return void
     */
    @Override
    public void run(){
        System.out.println("这是继承 Thread 类创建线程。");
    }
}
