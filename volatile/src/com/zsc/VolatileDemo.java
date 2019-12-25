package com.zsc;

import java.util.concurrent.TimeUnit;

/**
 * 利用volatile变量，demo
 */
public class VolatileDemo {

    public static volatile int vola_index;

    public static final int MAX = 50;

    public static void main(String[] args) {

        new Thread(()->{
            int local_index = vola_index;
            while (local_index < MAX){
                if (local_index != vola_index){
                    System.out.println("vola_index 发生变化" + vola_index );
                    local_index = vola_index;
                }
            }
        },"Read").start();

        new Thread(()->{
            int local_index = vola_index;
            while (local_index < MAX){
                System.out.println("update"+(++vola_index));
                local_index = vola_index;
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Write").start();
    }
}
