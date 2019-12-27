package com.zsc;

/**
 * 饿汉模式   安全，但是无法实现懒加载
 */
public class HungerSingleton {

    // 加载中就产生实例对象
    private static HungerSingleton hungerSingleton = new HungerSingleton();

    public static HungerSingleton getInstance(){
        return hungerSingleton;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                System.out.println(HungerSingleton.getInstance());
            }).start();
        }

    }
}
