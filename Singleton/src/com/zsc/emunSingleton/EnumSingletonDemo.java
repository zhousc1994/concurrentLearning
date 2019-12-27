package com.zsc.emunSingleton;

/**
 * 改良版，即可实现懒加载和线程安全
 */
public class EnumSingletonDemo {
    private EnumSingletonDemo(){

    }
    //延迟加载 (类似静态内部类）
    private enum EnumHolder{
        INSTANCE;
        private EnumSingletonDemo instance = null;

        EnumHolder(){
            instance = new EnumSingletonDemo();
        }
    }

    public static EnumSingletonDemo getInstance(){
        return EnumHolder.INSTANCE.instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                EnumSingletonDemo instance = getInstance();
                System.out.println(instance);
            }).start();
        }
    }
}
