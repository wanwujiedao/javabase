package com.dao.thread.core;

import java.util.concurrent.Callable;

/**
 * 使用 Callable 和 Future 创建线程
 *
 * @author 阿导
 * @version 1.0
 * @fileName com.dao.thead.core.MyCallable.java
 * @CopyRright (c) 2018-万物皆导
 * @created 2018-04-11 13:33:00
 */
public class MyCallable implements Callable<String> {

    /**
     * 实现 call() 方法
     * @author 阿导
     * @time 2018/4/11
     * @CopyRight 杭州微财科技有限公司
     * @param
     * @return java.lang.String
     */
    @Override
    public String call() throws Exception {
        System.out.println("这是使用 Callable 和 Future 创建线程。");
        return "万物皆导";
    }
}
