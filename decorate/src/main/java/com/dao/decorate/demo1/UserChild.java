package com.dao.decorate.demo1;

/**
 * 用户子类
 *
 * @author 阿导
 * @version 1.0
 * @fileName com.dao.decorate.demo1.UserChild.java
 * @CopyRright (c) 2018-万物皆导
 * @created 2018-04-08 13:21:00
 */
public class UserChild extends User {

    /**
     * 重写
     *
     * @author 阿导
     * @time 2018/4/8
     * @CopyRight 万物皆导
     * @param count
     * @return void
     */
    @Override
    public void setCount(int count) {
        super.setCount(++count);
    }
    /**
     * 重载
     *
     * @author 阿导
     * @time 2018/4/8
     * @CopyRight 万物皆导
     * @param count
     * @param num
     * @return void
     */
    public void setCount(int count,int num) {
        super.setCount(count+num);
    }
}
