package com.zhangrui.study.concurrency;

import java.math.BigDecimal;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 包含子串
 * @author: ZhangRui
 * @create: 2021-05-25 21:55
 **/
public class CountDownLatchCalculate {

    public static void main(String[] args) throws InterruptedException {
        int count = 4;
        Product[] products = new Product[count];

        for (int i = 0; i < count; i++) {
            products[i] = new Product(String.valueOf(i), BigDecimal.valueOf(i), BigDecimal.valueOf(i));
        }
        System.out.println(getTotalAmount(products));

    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class Product{
        private String name;

        private BigDecimal price;

        private BigDecimal discount;

        public BigDecimal getTotalAmount(){
            //不太记得方法了
            return price.multiply(discount);
        }
    }

    //总体思路就是用CountDownLatch 去分段多线程计算然后汇总
    public static BigDecimal getTotalAmount(Product[] products) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        if(products == null || products.length<1){
            return new BigDecimal(0);
        }
        //获取CPU个数
        //暂时先用4代替
        CountDownLatch countDown = new CountDownLatch(4);
        //这里使用JUC下面的一个原子类比较好，一时间记不起来，使用volatile应该还是会有线程安全问题
        AtomicReference<BigDecimal> result = new AtomicReference<BigDecimal>();
        result.set(new BigDecimal(0));
        //省略了try catch
        for (Product product : products) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    result.set(result.get().add(product.getTotalAmount()));
                    countDown.countDown();
                }
            });

        }
        countDown.await();
        executorService.shutdown();
        return result.get();
    }



}
