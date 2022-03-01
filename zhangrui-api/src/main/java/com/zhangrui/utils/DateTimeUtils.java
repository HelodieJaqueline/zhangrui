package com.zhangrui.utils;

import cn.hutool.core.date.LocalDateTimeUtil;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * @description: 日期工具类
 * @author: rui.zhang
 * @create: 2022-03-01 22:18
 */
public class DateTimeUtils {

    public static LocalDateTime toLocalDateTime(Date date) {
        return LocalDateTimeUtil.of(date);
    }

    public static LocalDateTime beginOfDay(LocalDateTime localDateTime) {
        return LocalDateTimeUtil.beginOfDay(localDateTime);
    }

    public static LocalDateTime endOfDay(LocalDateTime localDateTime) {
        return LocalDateTimeUtil.endOfDay(localDateTime);
    }

    public static long toEpochMilli(TemporalAccessor temporalAccessor) {
        return LocalDateTimeUtil.toEpochMilli(temporalAccessor);
    }

    public static LocalDateTime of(long epochMilli) {
        return LocalDateTimeUtil.of(epochMilli);
    }
}