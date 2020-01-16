package com.wenjie.xu;

public enum Topic {
	ZT_DMS_CBSTATUS("ZT_DMS_CBSTATUS","开关状态信息"),ZT_DMS_SOE("ZT_DMS_SOE","SOE信息"),ZT_DMS_TRANSACTION("ZT_DMS_TRANSACTION","量测设备异动信息");
	Topic(String id,String desc){
		this.desc = desc;
		this.id = id;
	}
	private String desc;
	private String id;
	public String getId() {
		return id;
	}
	public String getDesc() {
		return desc;
	}
	public static void main(String[] args) {
		System.out.println(Topic.ZT_DMS_CBSTATUS.name());
	}
}
