package com.zsc;

/**
 * Double-Check-Locking   双重检查锁单例
 * 这个写法貌似很完美，但是如果构造方法中存在指令重排的情况，会出现null指针
 * 解决方案：加上一个volatile,可以实现有序性，防止出现指令重排
 * Volatile+Double-check
 */
public class DCL {

//    private  static DCL instance;
    private volatile static DCL instance;

    private DCL(){

    }

    public static DCL getInstance(){
        if (instance == null){
            synchronized (DCL.class){
                if (instance == null){
                    instance = new DCL();
                }
            }
        }
        return instance;
    }

}
