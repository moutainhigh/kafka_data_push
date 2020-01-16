package com.wenjie.xu.parse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.wenjie.xu.Topic;
import com.wenjie.xu.entry.AbnormalMoveEntry;
import com.wenjie.xu.entry.DeviceInfoList;
import com.wenjie.xu.entry.TermInfoList;
import com.wenjie.xu.kafka.PushKafka;

public class AbnormalMovementMeasuringEquipment implements Runnable{
	private static final Logger logger = LoggerFactory.getLogger(AbnormalMovementMeasuringEquipment.class);
	private Map<String, List<Map<String, String>>> data;
	private Topic topic;
	public AbnormalMovementMeasuringEquipment(Topic topic,Map<String, List<Map<String, String>>> data){
		this.data = data;
		this.topic = topic;
	}
	@Override
	public void run() {
		if(data==null||data.size()<=0) return;
		List<AbnormalMoveEntry> list = new ArrayList<AbnormalMoveEntry>();
		AbnormalMoveEntry entry = null;
		TermInfoList termInfo = null;
		DeviceInfoList deviceInfo = null;
		for(String key : data.keySet()){
			for(Map<String, String> mp : data.get(key)){
				//FIXME: 对应数据 修改
				entry = new AbnormalMoveEntry();
				entry.setMsgId(mp.get("msgId"));
				entry.setTimeStamp("timeStamp");
					termInfo = new TermInfoList();
					termInfo.setFactory("factory");
					termInfo.setFeederID("feederID");
					termInfo.setLocationID("locationID");
					termInfo.setLocationName("locationName");
					termInfo.setNetMode("netMode");
					termInfo.setOffice("office");
					termInfo.setTermClass("termClass");
					termInfo.setTermId("termId");
					termInfo.setTermName("termName");
					termInfo.setTermStatStatic("termStatStatic");
					termInfo.setTermType("termType");
					termInfo.setTermZFGW("termZFGW");
						deviceInfo = new DeviceInfoList();
						deviceInfo.setDeviceId("deviceId");
						deviceInfo.setDeviceName("deviceName");
					termInfo.setDeviceInfoList(deviceInfo);;
				
				entry.setTermInfoList(termInfo);
				list.add(entry);
			}
		}
		try {
			PushKafka.push(topic.getId(), JSON.toJSONString(list));
		} catch (InterruptedException e) {
			logger.error(e.getLocalizedMessage(),e);
		} catch (ExecutionException e) {
			logger.error(e.getLocalizedMessage(),e);
		}
	}

}
