package com.dao.decorate.demo1;

import java.io.Serializable;

/**
 * 方法执行的先后顺序测试
 *
 * @author 阿导
 * @version 1.0
 * @fileName com.dao.decorate.demo1.User.java
 * @CopyRright (c) 2018-万物皆导
 * @created 2018-04-08 12:53:00
 */
public class User implements Serializable{

    private static final long serialVersionUID = 2922020512731211528L;

    /**
     * 静态常量
     */
    private static int staticcount;
    /**
     * 成员变量
     */
    private  int count;
    //构造块
    {
        System.out.println("然后执行->构造块["+(++count)+"]");
    }
    //静态块
    static {
        System.out.println("先执行->静态块["+(++staticcount)+"]");
    }
    //构造方法
    public User() {
        System.out.println("最后执行->构造方法，静态常量：["+(++staticcount)+"]，成员属性：["+(++count)+"]");
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
