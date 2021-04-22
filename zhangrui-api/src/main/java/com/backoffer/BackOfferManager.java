package com.backoffer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.aspectj.weaver.ast.Or;

/**
 * @description:
 * 1.买家在某平台网站上下了一笔交易订单，订单里包含不同商家的不同类型商品，平台为履行该笔交易，现在要给买家A发送包裹，要求：
 * 1）只要发货仓为同一个仓的都合并为一个包裹（用不同条码区分不同包裹）
 * 2）包裹明细要求：要求同一包裹内同一商家的商品必须相邻，且按销售额从高到低排序显示商品清单（销售额=商品数量乘以单价）
 * 请你为该平台设计一通用的包裹查询模块。
 *
 * 便于理解，假设该笔订单的商品详情为：
 * 供应商A(1)   商品0，数量5件，单价：7.00， 供货仓：嘉兴YX仓(1)
 * 供应商A(1)   商品1，数量3件，单价：6.00， 供货仓：余杭YX仓(2)
 * 供应商A(1)   商品2，数量2件，单价：5.00， 供货仓：余杭YX仓(2)
 *
 * 供应商B(2)   商品3，数量1件，单价： 3.00， 供货仓：嘉兴YX仓(1)
 * 供应商B(2)   商品4，数量8件，单价：4.00， 供货仓：嘉兴YX仓(1)
 * 供应商B(2)   商品5，数量4件，单价：2.00， 供货仓：余杭YX仓(2)
 *
 * 供应商C(3)   商品6，数量3件，单价：2.00， 供货仓：余杭YX仓(2)
 * 供应商C(3)   商品7，数量5件，单价：3.00， 供货仓：嘉兴YX仓(1)
 * @author: ZhangRui
 * @create: 2021-04-18 11:06
 **/
public class BackOfferManager {

    /**
     * 查询用户包裹
     * @param userId 用户id
     * @param orderId 订单id
     * @return
     */
    public Map<Long,Map<Long,List<Order>>> getOrderPackage(Long userId,String orderId) {
        //根据用户和订单查到详情(查询数据库)
        List<Order> orders = new ArrayList<>();

        //TODO 填充数据
        Order order = new Order(1L, 0L, new BigDecimal("7.00"), 5, 1L);
        orders.add(order);

        Order order2 = new Order(1L, 1L, new BigDecimal("6.00"), 3, 2L);
        orders.add(order2);

        Order order3 = new Order(1L, 2L, new BigDecimal("5.00"), 2, 2L);
        orders.add(order3);

        Order order4 = new Order(2L, 3L, new BigDecimal("3.00"), 1, 1L);
        orders.add(order4);

        Order order5 = new Order(2L, 4L, new BigDecimal("4.00"), 8, 1L);
        orders.add(order5);

        Order order6 = new Order(2L, 5L, new BigDecimal("2.00"), 4, 2L);
        orders.add(order6);

        Order order7 = new Order(3L, 6L, new BigDecimal("2.00"), 5, 2L);
        orders.add(order7);

        Order order8 = new Order(3L, 7L, new BigDecimal("3.00"), 5, 1L);
        orders.add(order8);

        //根据供货仓分类
        Map<Long, List<Order>> collect = orders.stream().collect(Collectors.groupingBy(Order::getRepertoryId));
        //最终包裹集合
        Map<Long,Map<Long,List<Order>>> result = new HashMap<>();
        for (Entry<Long, List<Order>> entry : collect.entrySet()) {
            //根据商家分类
            Map<Long, List<Order>> supplierMap = entry.getValue().stream()
                .collect(Collectors.groupingBy(Order::getSupplierId));
            for (Entry<Long, List<Order>> supplierEntry : supplierMap.entrySet()) {
                //按销售额的高低排序(已重新compareTo方法)
                Collections.sort(supplierEntry.getValue());
            }
            result.put(entry.getKey(), supplierMap);
        }
        return result;
    }


    /**
     * @description: 订单信息
     * @author: ZhangRui
     * @create: 2021-04-18 11:12
     **/
    @Data
    @AllArgsConstructor
    public static class Order implements Comparable<Order>{

        /**
         * 供应商
         */
        private Long supplierId;

        /**
         * 商品id
         */
        private Long goodId;

        /**
         * 单价
         */
        private BigDecimal goodPrice;

        /**
         * 数量
         */
        private Integer count;

        /**
         * 供货仓
         */
        private Long repertoryId;

        @Override
        public int compareTo(Order o) {
            return o.getTotalPrice().compareTo(this.getTotalPrice());
        }

        public BigDecimal getTotalPrice(){
            return goodPrice.multiply(new BigDecimal(count));
        }
    }

    public static void main(String[] args) {
        Map<Long, Map<Long, List<Order>>> orderPackage = new BackOfferManager().getOrderPackage(1L, "2");
        System.out.println(orderPackage);
    }
}
