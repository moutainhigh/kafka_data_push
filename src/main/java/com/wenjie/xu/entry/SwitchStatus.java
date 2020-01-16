package com.wenjie.xu.entry;

/**
 *  "SwitchStatus": {
	"mRId": 123456789, 设备 PMS_id
	"currentState": 1, 当前状态
	"value": 10, 变位信息
	"time": "2019-10-31\n13:30:00" 变位时间
 * @author 徐文杰
 *
 */
public class SwitchStatus {
	private String mRId;
	private String currentState;
	private String value;
	private String time;
	public String getmRId() {
		return mRId;
	}
	public void setmRId(String mRId) {
		this.mRId = mRId;
	}
	public String getCurrentState() {
		return currentState;
	}
	public void setCurrentState(String currentState) {
		this.currentState = currentState;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
}
