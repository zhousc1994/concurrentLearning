package com.zsc.emunSingleton;

/**
 * 使用枚举实现单例
 * 无法实现懒加载
 */
public enum  EnumSingleton {
    INSTANCE;

    public static EnumSingleton getInstance(){
        return INSTANCE;
    }

    public static void main(String[] args) {
        System.out.println(getInstance().getClass().getName());
    }
}
