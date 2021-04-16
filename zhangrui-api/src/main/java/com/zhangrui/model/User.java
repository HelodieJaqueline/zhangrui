package com.zhangrui.model;


import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class User {
    private Long id;

    private Long uid;

    private String name;

    @JSONField(format = "yyyy-MM-DD HH:mm:sss")
    private Date createDate;

    @JSONField(format = "yyyy-MM-DD HH:mm:sss")
    private Date updateDate;
}