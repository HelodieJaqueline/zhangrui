package com.zhangrui.designpattern.chain;

/**
 * @Author: ZhangRui
 * @Date: Created at 2019-03-07-14:50
 * @Description:
 * @Modified: By
 */
public class ErrorLogger extends AbstractLogger{

	public ErrorLogger(int level){
		this.level = level;
	}

	@Override
	protected void write(String message) {
		System.out.println("Error Console::Logger: " + message);
	}
}
