package com.zhangrui.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: ZhangRui
 * @Date: Created at 2019-02-25-19:57
 * @Description:
 * @Modified: By
 */
@Data
@NoArgsConstructor
public class StrategyRequest {
	private String type;

	private String phone;

	private String name;
}
