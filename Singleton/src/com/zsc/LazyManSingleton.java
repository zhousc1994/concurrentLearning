package com.zsc;

/**
 * 懒汉单例 ，多线程会出现多个实例，需要优化
 * 能够实现懒加载
 */
public class LazyManSingleton {

    public static LazyManSingleton lazyManSingleton;

    private LazyManSingleton(){
    }

    public static LazyManSingleton getInstance(){
        if (lazyManSingleton == null) {
            lazyManSingleton = new LazyManSingleton();
        }
        return lazyManSingleton;
    }

}
