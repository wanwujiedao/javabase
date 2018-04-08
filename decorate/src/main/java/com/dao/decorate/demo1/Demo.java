package com.dao.decorate.demo1;

import java.io.*;

/**
 * final，finally，finalize
 *
 * @author 阿导
 * @version 1.0
 * @fileName com.dao.decorate.demo1.Demo.java
 * @CopyRright (c) 2018-万物皆导
 * @created 2018-04-08 11:15:00
 */
public class Demo {
    private static final Integer AA[]={1};


    public static void main(String[] args) throws Exception {
        finalTest();
        new User();
        serializeUser();
        deserializeUser();
    }

    /**
     * 成员属性被 final 修饰测试
     * @author 阿导
     * @time 2018/4/8
     * @CopyRight 万物皆导
     * @param
     * @return void
     */
    public static void finalTest(){
        System.out.println("查看改变值前的地址："+AA);
        System.out.println("查看改变值前的值："+AA[0]);
        AA[0]=2;
        System.out.println("查看改变值后的地址："+AA);
        System.out.println("查看改变值后的值："+AA[0]);
    }


    /**
     * finally 示例
     *
     * @author 阿导
     * @time 2018/4/8
     * @CopyRight 万物皆导
     * @param
     * @return void
     */
    public static void finallyTest() throws IOException {
        FileInputStream fis=null;
        try {
            fis=new FileInputStream(new File("test.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            fis.close();
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.gc();
    }


    /**
     * 序列化
     *
     * @author 阿导
     * @time 2018/4/8
     * @CopyRight 万物皆导
     * @param
     * @return void
     */
    private static void serializeUser() throws IOException {
        User user = new User();

        // ObjectOutputStream 对象输出流，将 user 对象存储到 user.txt 文件中，完成对 user 对象的序列化操作
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("user.txt")));
        oos.writeObject(user);
        System.out.println("User 对象序列化成功！");
        oos.close();
    }

    /**
     * 反序列化
     *
     * @author 阿导
     * @time 2018/4/8
     * @CopyRight 万物皆导
     * @param
     * @return com.dao.decorate.demo1.User
     */
    private static User deserializeUser() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("user.txt")));
        User user = (User) ois.readObject();
        System.out.println("User 对象反序列化成功！");
        ois.close();
        return user;
    }
}
