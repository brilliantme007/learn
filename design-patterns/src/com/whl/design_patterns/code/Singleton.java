package com.whl.design_patterns.code;

/**
 * @Author: Wang HLiang
 * @Description: Write Elegant Code
 * @Date: Created in 9:36 2018-10-12
 * @Modofied:
 */
public class Singleton {

    private static Singleton singleton=new Singleton();

    public static Singleton getInstance(){
        return singleton;
    }
    public void doSomething(){
        System.out.println(singleton);
    }
}
