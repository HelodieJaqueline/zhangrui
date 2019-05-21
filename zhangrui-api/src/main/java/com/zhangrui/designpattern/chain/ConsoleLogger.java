package com.zhangrui.designpattern.chain;

/**
 * @Author: ZhangRui
 * @Date: Created at 2019-03-07-14:49
 * @Description:
 * @Modified: By
 */
public class ConsoleLogger extends AbstractLogger{

	public ConsoleLogger(int level){
		this.level = level;
	}

	@Override
	protected void write(String message) {
		System.out.println("Standard Console::Logger: " + message);
	}
}
