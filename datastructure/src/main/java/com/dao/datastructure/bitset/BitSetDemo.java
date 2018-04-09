package com.dao.datastructure.bitset;

import java.util.BitSet;

/**
 * 位集合
 *
 * @author 阿导
 * @version 1.0
 * @fileName com.dao.datastructure.bitset.BitSetDemo.java
 * @CopyRright (c) 2018-万物皆导
 * @created 2018-04-08 18:40:00
 */
public class BitSetDemo {

    public static void main(String[] args){
        BitSet bits1 = new BitSet(16);
        BitSet bits2 = new BitSet(16);
        BitSet bits3 = new BitSet(16);

        //添加一些位集合
        for(int i=0; i<1<<5; i++) {
            if((i%2) == 0){ bits1.set(i);}
            if((i%5) != 0){ bits2.set(i);}
            if((i%3) != 0){ bits3.set(i);}
        }
        System.out.println("bits1 初始化：");
        System.out.println(bits1);
        System.out.println("bits2 初始化：");
        System.out.println(bits2);

        //逻辑与
        bits2.and(bits1);
        System.out.println("bits2 与 bits1： ");
        System.out.println(bits2);

        // 逻辑或
        bits2.or(bits1);
        System.out.println("bits2 或 bits1: ");
        System.out.println(bits2);

        // 逻辑异或
        bits2.xor(bits3);
        System.out.println("bits2 异或 bits3: ");
        System.out.println(bits3);


    }
}
