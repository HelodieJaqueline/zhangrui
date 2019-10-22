package com.zhangrui.concurrency.locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: ZhangRui
 * @Date: Created at 2019-03-26-10:54
 * @Description:
 * @Modified: By
 */
public class ConditionDemo implements Runnable{
	private Lock lock;

	private Condition condition;

	public ConditionDemo(Lock lock, Condition condition) {
		this.lock = lock;
		this.condition = condition;
	}

	public static void main(String[] args) {
		Lock lock = new ReentrantLock();
		Condition condition = lock.newCondition();
		ConditionDemo demo = new ConditionDemo(lock, condition);
		demo.run();
	}

	@Override
	public void run() {
		System.out.println("begin -ConditionDemoWait");
		try {
			lock.lock();
			condition.await();
			System.out.println("begin -ConditionDemoWait");
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
}
/*
public class ConditionDemoWait implements  Runnable{
	private Lock lock;
	  private Condition condition;
	  public ConditionDemoWait(Lock lock, Condition condition){
	    this.lock=lock;
	    this.condition=condition;
	  }
	  @Override
  public void run() {
	    System.out.println("begin -ConditionDemoWait");
	    try {
	      lock.lock();
	      condition.await();
	      System.out.println("end - ConditionDemoWait");
	    } catch (InterruptedException e) {
	      e.printStackTrace();
	    }finally {
	      lock.unlock();
	    }
	  }
	}*/
