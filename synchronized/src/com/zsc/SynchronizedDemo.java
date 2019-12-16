package com.zsc;

import java.util.concurrent.TimeUnit;

public class SynchronizedDemo {

    /**
     * synchronized  用于静态方法
     */
    public static synchronized void run(){
        try {
            TimeUnit.SECONDS.sleep(2);   //使用TimeUnit实现
            System.out.println(Thread.currentThread().getName()+" is running");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    /**
     * synchronozed  用于非静态方法
     */
    public synchronized void run2(){
        try{
            TimeUnit.SECONDS.sleep(2);
            System.out.println(Thread.currentThread().getName()+" is running");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    /**
     *  synchronozed  用于锁对象 代码块
     */
    public void run3(){
        try{
            synchronized (this) {
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName() + " is running");
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    /**
     * 锁类  synchronozed
     */
    public void run4(){
        try{
            synchronized (SynchronizedDemo.class) {
                TimeUnit.MINUTES.sleep(2);
                System.out.println(Thread.currentThread().getName() + " is running");
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        SynchronizedDemo synchronizedDemo = new SynchronizedDemo();
        for (int i = 0; i < 5 ; i++) {
            new Thread(synchronizedDemo::run4).start();
        }
    }
}
