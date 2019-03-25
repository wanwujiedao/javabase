package com.dao.example;

/**
 * 死锁程序设计
 *
 * @author 阿导
 * @CopyRight 万物皆导
 * @Created 2019年03月25日 14:22:00
 */
public class DeadThread {
    /**
     *  A 执行的必要条件
     */
    private static Object conditionAB = new Object();
    /**
     * B 执行的必要条件
     */
    private static Object conditionBA = new Object();

    /**
     * 主程序
     * @param args
     */
    public static void main(String[] args) {
        // 线程 A
        Thread threadA = new Thread(()->{
         synchronized (conditionAB){
             System.out.println("A 线程开始");


             System.out.println("A 线程即将进入阻塞状态");

             synchronized (conditionBA){
                 System.out.println("A 线程阻塞状态结束");
             }

             System.out.println("A 线程结束");

         }
        });

        // 线程 B
        Thread threadB = new Thread(()->{
            synchronized (conditionBA){
                System.out.println("B 线程开始");

                System.out.println("B 线程即将进入阻塞状态");

                synchronized (conditionAB){
                    System.out.println("B 线程阻塞状态结束");
                }

                System.out.println("B 线程结束");

            }
        });

        threadA.start();
        threadB.start();
    }
}
