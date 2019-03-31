package com.zhangrui.jvm.classlodader;

public class TestLoadSequence {

    //按照类加载的顺序就没有问题了
    static int i = 1;
    static {
        i = 0;
        System.out.println(i);
    }
    //虽然在变量表已经有i了，但是在上面静态块里面的sout引用的是内存地址
/*    static int i = 1;*/
}
