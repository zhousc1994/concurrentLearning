package com.zsc.application;

/**
 * 双重检查锁
 */
public class DoubleCheckLock {

    public static volatile DoubleCheckLock doubleCheckLock;

    public static DoubleCheckLock getInstance(){
        if(doubleCheckLock == null){
            synchronized (DoubleCheckLock.class){
                doubleCheckLock = new DoubleCheckLock();
            }
        }
        return doubleCheckLock;
    }
}
