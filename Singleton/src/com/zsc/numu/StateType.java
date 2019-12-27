package com.zsc.numu;

import java.util.Arrays;

/**
 * 枚举类：
 * 1.enum定义的枚举类默认继承了java.lang.Enum类
 * 2.使用enum定义、非抽象的枚举类默认会使用final修饰，因此枚举类不能派生子类。
 * 3.枚举类的构造器只能使用private访问控制符，如果省略了构造器的访问控制符，则默认使用private修饰；如果强制指定访问控制符，则只能指定private修饰符。
 * 4.枚举类的所有实例必须在枚举类的第一行显式列出，否则这个枚举类永远都不能产生实例。
 * 5.枚举类默认提供了一个values()方法，该方法可以很方便地遍历所有的枚举值
 */
public enum StateType {
    /**
     * 成功返回
     */
    OK(200,"OK"),

    /**
     * 请求参数错误
     */
    BAD_REQUEST(400,"bad request"),

    /**
     * 未授权
     */
    UNAUTHORIZED(401,"unauthorized"),

    /**
     * 资源未找到
     */
    NOT_FOUND(404,"not found"),

    /**
     * 用户未登录
     */
    NOT_LOGIN(409,"用户未登录");

    private int code;

    private String msg;

    private StateType(int code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static void main(String[] args) {
        System.out.println(StateType.BAD_REQUEST.getCode());
        // 遍历枚举类型
        System.out.println(Arrays.toString(StateType.values()));
    }
}
