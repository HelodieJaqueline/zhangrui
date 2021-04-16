package com.zhangrui.domain;

public class Father {

    private String normalCode = "12345678";

    private String normalCode1 = "123456789";


    static {
        System.out.println("父类static块加载");
    }

    public Father(){
        System.out.println("父类构造方法");
    }
}
