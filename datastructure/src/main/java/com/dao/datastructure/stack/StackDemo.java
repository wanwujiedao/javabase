package com.dao.datastructure.stack;

import java.util.Stack;

/**
 * 栈示例代码
 *
 * @author 阿导
 * @version 1.0
 * @fileName com.dao.datastructure.stack.StackDemo.java
 * @CopyRright (c) 2018-万物皆导
 * @created 2018-04-09 19:34:00
 */
public class StackDemo {

    public static void main(String[] args){

        Stack<Integer> stack = new Stack<Integer>();

        //进栈
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack);
        //出栈
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
}
