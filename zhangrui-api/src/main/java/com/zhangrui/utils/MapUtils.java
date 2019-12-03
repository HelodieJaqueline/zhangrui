package com.zhangrui.utils;

import com.zhangrui.model.User;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ZhangRui
 * @Date: Created at 2019-12-03-17:57
 * @Description:
 * @Modified: By
 */
public class MapUtils {

    public static Map<String, Object> parseObjectToMap(Object object) {
        if (null == object) {
            return null;
        }
        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        if (null == fields || 0 == fields.length) {
            return null;
        }
        Map<String, Object> map = new HashMap<String, Object>();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                map.put(String.valueOf(field.getName()), field.get(String.valueOf(field.getName())));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return map;
    }

    public static void main(String[] args) {
        User user = new User();
        user.setName("TOM");
        System.out.println(parseObjectToMap(user));

    }
}
