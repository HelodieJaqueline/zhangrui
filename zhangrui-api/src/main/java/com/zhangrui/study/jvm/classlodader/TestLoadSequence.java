package com.zhangrui.study.jvm.classlodader;

public class TestLoadSequence {

    //按照类加载的顺序就没有问题了
    static int i = 1;
    static {
        //虽然在变量表已经有i了，但是sout引用的是内存地址
        i = 0;
        System.out.println(i);
    }
     //error
/*    static int i = 1;*/
}
