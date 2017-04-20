package com.topsuntech.gUnit.gEU_util.tools;

import java.util.TimerTask;

import com.topsuntech.gOS.logger.Logger;

public abstract class TimerTaskUtil extends TimerTask {
	private Class clazz;

	/**
	 * 未运行
	 */
	public static final int SCHEDULED = 0;

	/**
	 * 运行中
	 */
	public static final int EXECUTED = 1;

	/**
	 * 运行完毕
	 */
	public static final int ENDED = 2;

	/**
	 * 异常退出
	 */
	public static final int ERRORED = 3;

	/**
	 * 运行状态
	 */
	private int state = SCHEDULED;

	private long startTime;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public void start(Class clazzs) {
		this.state = EXECUTED;
		this.clazz = clazzs;
		Logger.info(getName() + "开始运行...");
		startTime = System.currentTimeMillis();
	}

	private String getName() {
		return "["
				+ this.clazz.getName().replaceAll(this.clazz.getPackage().getName(), "").substring(
						1) + "]";
	}

	private long getRunTime() {
		return (System.currentTimeMillis() - startTime) / (1000 * 60);
	}

	public void end() {
		this.state = ENDED;
		Logger.info(getName() + "运行结束,运行时间" + getRunTime() + "分钟");
	}

	public void error(Exception e) {
		this.state = ERRORED;
		Logger.info(getName() + "运行异常退出,原因" + e.getMessage() + ",运行时间" + getRunTime() + "分钟");
	}

	public boolean isRunning() {
		return (this.state == EXECUTED);
	}

	public boolean isNoStart() {
		return this.state == SCHEDULED;
	}

	public boolean isEnd() {
		return this.state == ENDED || this.state == ERRORED;
	}

	public abstract void run();
}
