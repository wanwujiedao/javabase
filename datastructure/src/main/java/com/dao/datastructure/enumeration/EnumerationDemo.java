package com.dao.datastructure.enumeration;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

/**
 * 枚举案例
 *
 * @author 阿导
 * @version 1.0
 * @fileName com.dao.datastructure.enumeration.EnumerationDemo.java
 * @CopyRright (c) 2018-万物皆导
 * @created 2018-04-08 17:28:00
 */
public class EnumerationDemo {

    public static void main(String[] args){
        Enumeration<String> season;
        Vector<String> seasonNames = new Vector<>();
        seasonNames.add("Spring");
        seasonNames.add("Summer");
        seasonNames.add("Autumn");
        seasonNames.add("Winter");
        season = seasonNames.elements();
        while (season.hasMoreElements()){
            System.out.println(season.nextElement());
        }
    }
}
