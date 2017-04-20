package com.topsuntech.gUnit.gEU_util.tools;

import java.util.TimerTask;

import com.topsuntech.gOS.logger.Logger;

public abstract class TimerTaskUtil extends TimerTask {
	private Class clazz;

	/**
	 * δ����
	 */
	public static final int SCHEDULED = 0;

	/**
	 * ������
	 */
	public static final int EXECUTED = 1;

	/**
	 * �������
	 */
	public static final int ENDED = 2;

	/**
	 * �쳣�˳�
	 */
	public static final int ERRORED = 3;

	/**
	 * ����״̬
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
		Logger.info(getName() + "��ʼ����...");
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
		Logger.info(getName() + "���н���,����ʱ��" + getRunTime() + "����");
	}

	public void error(Exception e) {
		this.state = ERRORED;
		Logger.info(getName() + "�����쳣�˳�,ԭ��" + e.getMessage() + ",����ʱ��" + getRunTime() + "����");
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
