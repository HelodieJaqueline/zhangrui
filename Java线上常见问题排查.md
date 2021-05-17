# Java线上常见问题排查

#### 																														张锐

## 常见问题分类

### CPU飙高

### 内存溢出

* Heap

* Stack

* MetaSpace

### GC频繁

### 接口响应慢

### 死锁

## 工具

### JDK自带
* jps
* jstack
* jstat
* jmap
* jconsole
* jvisualvm

## 不使用Arthas,如何定位？
* CPU飙高

  top 

  找到CPU使用率高的进程

top -H -p [pid] 

​		找到对应进程CPU使用率高的线程

printf "%x\n" tid

​		线程id转换成16进制

jstack > jstack_jvm.txt

​		dump 线程堆栈信息

* 查看GC情况

  jstat -gcutil [pid] 1000

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
    
* watch
    
    观察到指定方法的调用情况,返回值、抛出异常、入参
    
* trace 
    
    方法内部调用路径，并输出方法路径上的每个节点上耗时
    
* heapdump
    
    dump内存
    
* ……




## 实战

启动应用

java -jar -Xms100M -Xmx100M  zhanguri-jvm-0.0.1-SNAPSHOT.jar &

打印GC日志，在内存溢出时dump内存

java -jar -Xms100M -Xmx100M -XX:+PrintGCDateStamps -XX:+PrintGCDetails -XX:+PrintHeapAtGC -Xloggc:/data/logs/jvm/gc-%t.log -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/data/logs/jvm/java_heapdump.hprof zhanguri-jvm-0.0.1-SNAPSHOT.jar &



* 内存溢出、FullGC频繁
  
  模拟内存溢出
  
  ```java
  @RestController
  public class HeapController {
      List<Person> list=new ArrayList<Person>();
  
      @GetMapping("/heap")
      public String heap(){
          while(true){
              list.add(new Person());
          }
      }
  }
  ```
  
  dashboard
  
  查询内存使用情况、GC次数及时间、dump内存
  
  heapdump /data/logs/jvm/dump.hprof
  
  使用MAT等工具分析内存信息
  
* CPU使用率，负载很高
    
    模拟CPU使用率高
    
    ```java
    @RestController
    public class CPUHighUsageController {
    
    
        @GetMapping(value = "/cpuHighUsage")
        public long cpuHighUsage(Long limit) {
            long count = 0;
            do {
                count++;
            } while (count <= limit);
            return count;
        }
    
    }
    ```
    
    
    
    thread -n 3
    
* 死锁
    
    模拟死锁情况
    
    ```java
    @RestController
    public class DeadLockController {
    
    
        @GetMapping("/deadLock")
        public void deadLock() {
            DeadLock d1=new DeadLock(true);
            DeadLock d2=new DeadLock(false);
            Thread t1=new Thread(d1);
            Thread t2=new Thread(d2);
            t1.start();
            t2.start();
        }
    
    
        //定义锁对象
        static class MyLock{
            public static Object obj1=new Object();
            public static Object obj2=new Object();
        }
        //死锁代码
        static class DeadLock implements Runnable {
            private boolean flag;
    
            DeadLock(boolean flag) {
                this.flag = flag;
            }
    
            @Override
            public void run() {
                if (flag) {
                    while (true) {
                        synchronized (MyLock.obj1) {
                            System.out.println(Thread.currentThread().getName() + "----if获得obj1锁");
                            synchronized (MyLock.obj2) {
                                System.out.println(Thread.currentThread().getName() + "----if获得obj2锁");
                            }
                        }
                    }
                } else {
                    while (true) {
                        synchronized (MyLock.obj2) {
                            System.out.println(Thread.currentThread().getName() + "----否则获得obj2锁");
                            synchronized (MyLock.obj1) {
                                System.out.println(Thread.currentThread().getName() + "----否则获得obj1锁");
    
                            }
                        }
                    }
                }
            }
        }
    }
    
    ```
    
    thread -b
    
* 接口响应慢
    
    模拟接口响应慢
    
    ```java
    @RestController
    public class SlowController {
    
        @Autowired
        private UserService userService;
    
        @GetMapping(value = "/slow")
        public Long slow(Long id) throws InterruptedException {
            return userService.slow(id);
        }
    
    }
    
    @Service
    @Slf4j
    public class UserServiceImpl implements UserService {
    
        @Autowired
        private OrderService orderService;
    
    
        @Override
        public Long slow(Long id) throws InterruptedException {
            log.info("接口响应慢！！！！");
            TimeUnit.MILLISECONDS.sleep(RandomUtils.nextInt(300, 600));
            return orderService.slow(id);
        }
    
    }
    
    @Service
    public class OrderServiceImpl implements OrderService {
    
    
        @Override
        public Long slow(Long id) throws InterruptedException {
            //模拟接口响应慢
            TimeUnit.SECONDS.sleep(RandomUtils.nextInt(1, 3));
            return id;
        }
    }
    
    
    ```
    
    trace com.zhangrui.jvm.controller.SlowController slow
    
* 在我机器上是好的，怎么线上就不行？谁动了我的代码
    
    模拟代码不一致及实时观察方法调用情况
    
    ```java
    @RestController
    @Slf4j
    public class WatchMethodController {
    
        @Autowired
        private ThirdService thirdService;
    
    
        @GetMapping("/watch")
        public Map<Integer,Object> watch(Integer count) {
            Map<Integer,Object> result = new HashMap<>();
            if (null == count) {
                return result;
            }
            String value = methodA(count);
            value = methodB(value);
            value = methodC(value);
            value = thirdService.thirdMethod(value);
            result.put(count, value);
            return result;
        }
    
        private String methodA(Integer i) {
            String result = i + "A";
            log.info("methodA result :{}", result);
            return result;
        }
    
        private String methodB(String i) {
            return i + "B";
        }
    
        private String methodC(String i) {
            return i + "C";
        }
    
    
    }
    ```
    
    jad 反编译
    
    jad com.zhangrui.jvm.controller.WatchMethodController
    
    watch 观察到指定方法的调用情况
    
    watch com.zhangrui.jvm.controller.WatchMethodController watch "{params,returnObj}"  -x 2 -s
    
    **合同问题定位**
    
    电子合同签署完成回调成功，但是电子合同状态还是未签署
    
    ```java
    [arthas@19263]$ watch com.baoyuan.contract.mapper.ContractEsignContentMapper listContentByFlowId "{params,returnObj}"  -x 2 -s
    Press Q or Ctrl+C to abort.
    Affect(class count: 3 , method count: 2) cost in 421 ms, listenerId: 2
    method=com.sun.proxy.$Proxy141.listContentByFlowId location=AtExit
    ts=2021-05-14 14:25:19; [cost=14.76036ms] result=@ArrayList[
        @Object[][
            @String[16cee225233b4f898d8e356b34b82dc5],
            null,
        ],
        @ArrayList[isEmpty=true;size=0],
    ]
    method=com.sun.proxy.$Proxy142.listContentByFlowId location=AtExit
    ts=2021-05-14 14:25:19; [cost=80.024988ms] result=@ArrayList[
        @Object[][
            @String[16cee225233b4f898d8e356b34b82dc5],
            null,
        ],
        @ArrayList[isEmpty=true;size=0],
    ]
    method=com.sun.proxy.$Proxy141.listContentByFlowId location=AtExit
    ts=2021-05-14 14:25:19; [cost=6.364366ms] result=@ArrayList[
        @Object[][
            @String[16cee225233b4f898d8e356b34b82dc5],
            null,
        ],
        @ArrayList[isEmpty=true;size=0],
    ]
    method=com.sun.proxy.$Proxy142.listContentByFlowId location=AtExit
    ts=2021-05-14 14:25:19; [cost=8.399824ms] result=@ArrayList[
        @Object[][
            @String[16cee225233b4f898d8e356b34b82dc5],
            null,
        ],
        @ArrayList[isEmpty=true;size=0],
    ]
    
    ```
    
    ```
    @Override
    public List<ContractEsignContent> listContentByFlowId(String flowId) {
        return contractEsignContentMapper.listContentByFlowId(flowId,ExternalContext.currentExternal().getTenantId());
    }
    ```

最终定位问题是租户id为null造成的

**tt 方法执行数据的时空隧道，记录下指定方法每次调用的入参和返回信息，并能对这些不同的时间下调用进行观测**

tt -t  watch com.zhangrui.jvm.controller.WatchMethodController watch   

**记录下指定方法每次调用的入参和返回信息**

```java
 1000     2021-05-14 16:44:27     1.540995   true      false    0xde9e918         WatchMethodController              watch                             
 1001     2021-05-14 16:44:27     0.292789   true      false    0xde9e918         WatchMethodController              watch                             
 1002     2021-05-14 16:44:28     0.226579   true      false    0xde9e918         WatchMethodController              watch                             
 1003     2021-05-14 16:44:28     0.589971   true      false    0xde9e918         WatchMethodController              watch                             
 1004     2021-05-14 16:44:31     0.172811   true      false    0xde9e918         WatchMethodController              watch                             
 1005     2021-05-14 16:44:32     0.296357   true      false    0xde9e918         WatchMethodController              watch                             
 1006     2021-05-14 16:44:32     0.17124    true      false    0xde9e918         WatchMethodController              watch                             
 1007     2021-05-14 16:44:32     0.54105    true      false    0xde9e918         WatchMethodController              watch                             
 1008     2021-05-14 16:44:33     0.210583   true      false    0xde9e918         WatchMethodController              watch                             
 1009     2021-05-14 16:44:33     0.38163    true      false    0xde9e918         WatchMethodController              watch                             
 1010     2021-05-14 16:44:34     0.145752   true      false    0xde9e918         WatchMethodController              watch                             
 1011     2021-05-14 16:44:34     0.254862   true      false    0xde9e918         WatchMethodController              watch                             
 1012     2021-05-14 16:44:35     0.180544   true      false    0xde9e918         WatchMethodController              watch                             
 1013     2021-05-14 16:44:35     0.169244   true      false    0xde9e918         WatchMethodController              watch                             
 1014     2021-05-14 16:44:36     0.160209   true      false    0xde9e918         WatchMethodController              watch                             
 1015     2021-05-14 16:44:36     0.196402   true      false    0xde9e918         WatchMethodController              watch                             
 1016     2021-05-14 16:44:36     0.152395   true      false    0xde9e918         WatchMethodController              watch                             
 1017     2021-05-14 16:44:37     0.244198   true      false    0xde9e918         WatchMethodController              watch                             
 1018     2021-05-14 16:44:38     0.184433   true      false    0xde9e918         WatchMethodController              watch                             
 1019     2021-05-14 16:44:39     0.215057   true      false    0xde9e918         WatchMethodController              watch                             
Affect(row-cnt:20) cost in 7 ms.

```



tt -i 1000

**查看调用信息**

```jav
 INDEX          1000                                                                                                                                   
 GMT-CREATE     2021-05-14 16:44:27                                                                                                                    
 COST(ms)       1.540995                                                                                                                               
 OBJECT         0xde9e918                                                                                                                              
 CLASS          com.zhangrui.jvm.controller.WatchMethodController                                                                                      
 METHOD         watch                                                                                                                                  
 IS-RETURN      true                                                                                                                                   
 IS-EXCEPTION   false                                                                                                                                  
 PARAMETERS[0]  @Integer[10]                                                                                                                           
 RETURN-OBJ     @HashMap[                                                                                                                              
                    @Integer[10]:@String[10ABC],                                                                                                       
                ]                                                                                                                                      
Affect(row-cnt:1) cost in 3 ms.

```

tt -i 1000 -p

**重做一次调用**

```java
[arthas@16830]$ tt -i 1000 -p
 RE-INDEX       1000                                                                                                                                   
 GMT-REPLAY     2021-05-14 16:48:52                                                                                                                    
 OBJECT         0xde9e918                                                                                                                              
 CLASS          com.zhangrui.jvm.controller.WatchMethodController                                                                                      
 METHOD         watch                                                                                                                                  
 PARAMETERS[0]  @Integer[10]                                                                                                                           
 IS-RETURN      true                                                                                                                                   
 IS-EXCEPTION   false                                                                                                                                  
 COST(ms)       0.427272                                                                                                                               
 RETURN-OBJ     @HashMap[                                                                                                                              
                    @Integer[10]:@String[10ABC],                                                                                                       
                ]                                                                                                                                      
Time fragment[1000] successfully replayed 1 times.


```

## Arthas会带来一定的性能损耗，定位完问题记得及时关闭(stop)。

    Arthas也不是万能的，更多情况还是要在开发过程中多注意。代码规范，代码的健壮性，重要方法调用记录日志及耗时！

