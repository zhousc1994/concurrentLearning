package com.zsc;

/**
 * 静态内部类单例模式
 * 应用比较广泛  安全  也可以实现懒加载
 */
public class HolderDemo {

    private HolderDemo(){

    }

    private static class Holder{
        private static HolderDemo instance = new HolderDemo();
        // 测试懒加载
        static {
            System.out.println("加载了");
        }
    }

    public static HolderDemo getInstance(){
        return Holder.instance;
    }

    public static void main(String[] args) {
//        System.out.println(new HolderDemo());
        System.out.println(new HolderDemo.Holder());
        System.out.println(getInstance());
    }

}
