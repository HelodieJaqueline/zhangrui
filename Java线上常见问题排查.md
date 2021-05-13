# Java线上常见问题排查

## 常见问题分类

### 内存溢出

* Heap

* Stack

* MetaSpace

### CPU飙高

* 循环调用
* 

### GC频繁

### 接口响应慢

### 死锁

## 工具

### JDK自带
* jps
* jstack
* jstat
* jmap


### Arthas

`Arthas` 是Alibaba开源的Java诊断工具

https://arthas.aliyun.com/doc/index.html

安装
curl -O https://arthas.aliyun.com/arthas-boot.jar

启动
java -jar arthas-boot.jar

常用命令
* dashboard
    展示当前进程的信息,概览
* thread
    查看线程堆栈信息
* jad
    反编译类
    jad com.zhangrui.jvm.controller.HeapController
* watch
    watch com.zhangrui.jvm.controller.SlowController slow returnObj

* ……




## 实战

启动应用
java -jar -Xms100M -Xmx100M -XX:+PrintGCDateStamps -XX:+PrintGCDetails -XX:+PrintHeapAtGC -Xloggc:/data/logs/jvm/gc-%t.log -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/data/logs/jvm/java_heapdump.hprof zhanguri-jvm-0.0.1-SNAPSHOT.jar &
