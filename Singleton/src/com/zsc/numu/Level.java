package com.zsc.numu;

public enum Level {

    ONE(1),

    TWO(2),

    THREE(3),

    FOUR(4),

    FIVE(5);

    private int value;

    private Level(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static void main(String[] args) {
        System.out.println(Level.valueOf("FIVE").value);
        System.out.println(Level.FOUR.getValue());
    }
}
