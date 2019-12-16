package com.zsc.exercise;

import java.util.Arrays;
import java.util.Random;

/**
 * 买飞机票demo
 * 输入  地点
 */
public class Exercise implements Runnable {

    public static synchronized String[] buyTickets(String address,String tagAdds){
        Random random = new Random();
        String[] strings = new String[3];
        String threadName = Thread.currentThread().getName();
        int index = random.nextInt(2);
        if(index == 0){
            strings[0] = "东方航空";
            strings[1] = address +"-"+tagAdds;
        }
        if(index == 1){
            strings[0] = "南方航空";
            strings[1] = address +"-"+tagAdds;
        }
        if(index == 2){
            strings[0] = "海航航空";
            strings[1] = address +"-"+tagAdds;
        }
        strings[2] = threadName;
        return strings;
    }

    @Override
    public void run() {
        String[] strings = buyTickets("上海", "北京");
        System.out.println(Arrays.toString(strings));
    }


    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(new Exercise()).start();
        }
    }


}
