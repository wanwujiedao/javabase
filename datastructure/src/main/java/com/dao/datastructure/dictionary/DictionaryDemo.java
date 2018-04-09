package com.dao.datastructure.dictionary;

import java.util.Dictionary;
import java.util.Hashtable;

/**
 * 字典
 *
 * @author 阿导
 * @version 1.0
 * @fileName com.dao.datastructure.dictionary.DictionaryDemo.java
 * @CopyRright (c) 2018-万物皆导
 * @created 2018-04-09 20:02:00
 */
public class DictionaryDemo {


    public static void main(String[] args){
        Dictionary<String,String>  dictionary=new Hashtable();

        dictionary.put("A","a");
        dictionary.put("B","b");
        dictionary.put("C","c");

        System.out.println("所有字典项:"+dictionary);
        System.out.println("C："+dictionary.get("C"));
    }
}
