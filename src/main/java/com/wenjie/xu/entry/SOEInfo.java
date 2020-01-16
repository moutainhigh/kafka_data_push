package com.wenjie.xu.entry;

/**
	"STATUS":"1",  质量码
	"time":"2019-11-17 07:52:12.131"
	"mRId":"123456789",  设备pmsid
	"value":"1", 变位信息
 * @author 徐文杰
 *
 */
public class SOEInfo {
	private String STATUS;
	private String time;
	private String mRId;
	private String value;
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getmRId() {
		return mRId;
	}
	public void setmRId(String mRId) {
		this.mRId = mRId;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
}
