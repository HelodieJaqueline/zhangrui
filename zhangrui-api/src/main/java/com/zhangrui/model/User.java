package com.zhangrui.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class User {
    private Long id;

    private Long uid;

    private String name;

    private Date createDate;

    private Date updateDate;
}