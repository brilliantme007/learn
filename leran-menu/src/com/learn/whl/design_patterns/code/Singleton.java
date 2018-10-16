package com.learn.whl.design_patterns.code;

/**
 * @Author: Wang HLiang
 * @Description: Write Elegant Code
 * @Date: Created in 9:36 2018-10-12
 * @Modofied:
 */
public class Singleton {

    private static Singleton singleton;

    //提供私有构造函数,确保外部不能直接创建该类的实例
    private Singleton(){
    }
    //提供全局访问点,双重锁机制,确保线程安全的同时也考虑到性能问题
    public static Singleton getInstance(){
        if(singleton==null){
            synchronized (Singleton.class){
                if(singleton==null){
                    singleton=new Singleton();
                }
            }
        }
        return singleton;
    }
    public void doSomething(){
        System.out.println(singleton);
    }
}
