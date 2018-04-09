package com.dao.datastructure.vector;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 向量
 *
 * @author 阿导
 * @version 1.0
 * @fileName com.dao.datastructure.vector.VectorDemo.java
 * @CopyRright (c) 2018-万物皆导
 * @created 2018-04-08 18:52:00
 */
public class VectorDemo {

    public static void main(String[] args){
        // 初始化增量为2，大小为4
        Vector v = new Vector(4, 2);
        System.out.println("当前向量数目: " + v.size());
        System.out.println("当前向量的容量: " +
                v.capacity());
        v.addElement(new Integer(10));
        v.addElement(new Integer(24));
        v.addElement(new Integer(37));
        v.addElement(new Integer(43));
        v.addElement(new Integer(52));
        //因为增量是2，所以向量的容量应该为4+2=6
        System.out.println("增加五个向量后的容量: " +v.capacity());
        //再添加一个向量
        v.addElement(new Double(3.37));
        //此时，向量里面应该是6个元素，其容量依然为6
        System.out.println("添加3.37后的容量: " +v.capacity());
        //在添加一个元素，容量加2，元素个数加1
        v.addElement(new Integer(7));
        System.out.println("添加7后的容量: " +v.capacity());
        System.out.println("添加7后的元素个数: " +v.size());

        System.out.println("第一个元素: " +v.firstElement());
        System.out.println("最后一个元素: " +v.lastElement());

        if(v.contains(new Double(3.37))) {
            System.out.println("\nVector 包含 3.37。");
        }
        // 对向量里面元素进行遍历
        Enumeration vEnum = v.elements();
        System.out.println("\n以下是向量里面的元素：");
        while(vEnum.hasMoreElements()) {
            System.out.print(vEnum.nextElement() + " ");
        }
        System.out.println();
    }
}
