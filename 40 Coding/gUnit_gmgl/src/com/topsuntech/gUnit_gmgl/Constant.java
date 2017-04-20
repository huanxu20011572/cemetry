package com.topsuntech.gUnit_gmgl;

/**
 * 常量定义
 * 
 * @author baiweiming
 * 
 */
public final class Constant {

	// 是,有效
	public static final int YES = 1;
	// 否,无效
	public static final int NO = 0;

	// 男
	public static final int MALE = 1;
	// 女
	public static final int FEMALE = 0;

	// 墓位状态1开发，2空闲，3锁定，4保留，5预定，6占有，7迁出
	/**
	 * 1开发
	 */
	public static final int CEMETERY_STATUS_EXPLOIT = 1;
	/**
	 * 2空闲>退墓
	 */
	public static final int CEMETERY_STATUS_FREE = 2;
	/**
	 * 3锁定>租用完成
	 */
	public static final int CEMETERY_STATUS_LOCK = 3;
	/**
	 * 4保留>租用登记、编辑
	 */
	public static final int CEMETERY_STATUS_RETAIN = 4;
	/**
	 * 5预定
	 */
	public static final int CEMETERY_STATUS_SUBSCRIBE = 5;
	/**
	 * 6占用>租用归档
	 */
	public static final int CEMETERY_STATUS_HOLD = 6;
	/**
	 * 7迁出>迁出登记
	 */
	public static final int CEMETERY_STATUS_REMOVAL = 7;

	// 登记类型1租用，2续租，3合葬，4迁出，5退墓
	/**
	 * 1租用
	 */
	public static final int REGEDIT_TYPE_RENT = 1;
	/**
	 * 2续租
	 */
	public static final int REGEDIT_TYPE_RELET = 2;
	/**
	 * 3合葬
	 */
	public static final int REGEDIT_TYPE_MULTI = 3;
	/**
	 * 4迁出
	 */
	public static final int REGEDIT_TYPE_REMOVAL = 4;
	/**
	 * 5退墓
	 */
	public static final int REGEDIT_TYPE_BACK = 5;

	// 穴别1单穴，2双穴，3其他
	/**
	 * 1单穴
	 */
	public static final int CAVE_SINGLE = 1;
	/**
	 * 2双穴
	 */
	public static final int CAVE_PAIR = 2;
	/**
	 * 3多穴
	 */
	public static final int CAVE_MULTI = 3;

	// 墓型照片
	public static final int FILE_TYPE_PIC = 1;
	// 登记附件
	public static final int FILE_TYPE_ATT = 2;

	// 出库类型1,售卖2，赠送，3损耗
	/**
	 * 1售卖
	 */
	public static final int OUT_STOREHOUSE_SELL = 1;
	/**
	 * 2.赠送
	 */
	public static final int OUT_STOREHOUSE_GIVE = 2;
	/**
	 * 3.损耗
	 */
	public static final int OUT_STOREHOUSE_LOSS = 3;

}
