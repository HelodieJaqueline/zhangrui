package com.zhangrui.domain.request;

import lombok.Data;

/**
 * @Author: ZhangRui
 * @Date: Created at 2019-02-25-20:16
 * @Description:
 * @Modified: By
 */
@Data
public class OpenRegisterParam implements IRegisterParam{

	private String state;

	private String name;
}
