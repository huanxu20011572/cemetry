package com.topsuntech.gUnit_gmgl.core;

/**
 * 消息类型
 * 
 * @author xuh 下午04:05:51 2014-6-19
 * 
 */
public enum MessageType {
	/**
	 * 错误消息
	 */
	error {
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "error";
		}
	},
	/**
	 * 提示消息
	 */
	info {
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "info";
		}
	},
	/**
	 * 警告消息
	 */
	warn {
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "warn";
		}
	},
	/**
	 * 确认消息
	 */
	conform {
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "conform";
		}
	},
	/**
	 * 无消息
	 */
	noMessage {
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "noMessage";
		}
	}
}
