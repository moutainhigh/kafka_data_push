package com.wenjie.xu.entry;

/**
 * 配电网SOE信息
 * {
	"MsgId":"1234567",
	"timeStamp":"2017-01-01 13:30:00",
	"SOEInfo"： 
 * @author 徐文杰
 *
 */
public class SOEEntry extends Entry{
	private SOEInfo SOEInfo;
	public SOEInfo getSOEInfo() {
		return SOEInfo;
	}
	public void setSOEInfo(SOEInfo sOEInfo) {
		SOEInfo = sOEInfo;
	}
}
