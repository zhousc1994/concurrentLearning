package com.zsc.application;

/**
 * 开关模式（状态标志）
 */
public class Switch extends Thread {

    public volatile boolean started = true;

    @Override
    public void run() {
        while (started){
            System.out.println("工作中...........");
        }
    }

    public void shutDown(){
        System.out.println("关机");
        started = false;
    }

    public static void main(String[] args) {
        Switch aSwitch = new Switch();
        aSwitch.start();

        try {
            Thread.sleep(1000);
            aSwitch.shutDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
