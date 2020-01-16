package com.wenjie.xu.entry;

import java.util.ArrayList;
import java.util.List;

/**
 * [
{
"termId": 3802726935595843600,
"termName": "崾岘 1 号配电室终端",
"locationName": "崾岘变 514 陡坡线 058 杆开关",
"locationID": 3802726936788904400,
"office": null,
"factory": "南瑞集团",
"termType": 1,
"termClass": 2,
"feederID": "10000100_32177",
"netMode": "无线",
"termStatStatic": 1,
"termZFGW": 1,
"deviceInfoList": [
{
"deviceId": 38027269355950430000,
"deviceName": "青林闲庭 1 号配电室闲青 AA021 线 G12 接地刀闸"
}
]
}
]
 * @author 徐文杰
 *
 */
public class TermInfoList {
	private String termId;
	private String termName;
	private String locationName;
	private String locationID;
	private String office;
	private String factory;
	private String termType;
	private String termClass;
	private String feederID;
	private String netMode;
	private String termStatStatic;
	private String termZFGW;
	private List<DeviceInfoList> deviceInfoList = new ArrayList<DeviceInfoList>();
	public String getTermId() {
		return termId;
	}
	public void setTermId(String termId) {
		this.termId = termId;
	}
	public String getTermName() {
		return termName;
	}
	public void setTermName(String termName) {
		this.termName = termName;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public String getLocationID() {
		return locationID;
	}
	public void setLocationID(String locationID) {
		this.locationID = locationID;
	}
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}
	public String getFactory() {
		return factory;
	}
	public void setFactory(String factory) {
		this.factory = factory;
	}
	public String getTermType() {
		return termType;
	}
	public void setTermType(String termType) {
		this.termType = termType;
	}
	public String getTermClass() {
		return termClass;
	}
	public void setTermClass(String termClass) {
		this.termClass = termClass;
	}
	public String getFeederID() {
		return feederID;
	}
	public void setFeederID(String feederID) {
		this.feederID = feederID;
	}
	public String getNetMode() {
		return netMode;
	}
	public void setNetMode(String netMode) {
		this.netMode = netMode;
	}
	public String getTermStatStatic() {
		return termStatStatic;
	}
	public void setTermStatStatic(String termStatStatic) {
		this.termStatStatic = termStatStatic;
	}
	public String getTermZFGW() {
		return termZFGW;
	}
	public void setTermZFGW(String termZFGW) {
		this.termZFGW = termZFGW;
	}
	public List<DeviceInfoList> getDeviceInfoList() {
		return deviceInfoList;
	}
	public void setDeviceInfoList(DeviceInfoList deviceInfoList) {
		if(deviceInfoList==null) return;
		this.deviceInfoList.add(deviceInfoList);
	}
}
