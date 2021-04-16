package com.zhangrui.study.pattern.chain;

/**
 * @Author: ZhangRui
 * @Date: Created at 2019-03-07-14:51
 * @Description:
 * @Modified: By
 */
public class FileLogger extends AbstractLogger {

	public FileLogger(int level) {
		this.level = level;
	}

	@Override
	protected void write(String message) {
		System.out.println("File::Logger: " + message);
	}
}