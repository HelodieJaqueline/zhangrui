package com.zhangrui.domain;

public class Son extends Father{

    private String normalCode2 = "12345678";

    private String normalCode3 = "123456789";

    static {
        System.out.println("子类static块加载");
    }

    public Son(){
        System.out.println("子类构造方法");
    }
}
