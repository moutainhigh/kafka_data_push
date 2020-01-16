package com.wenjie.xu.parse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.wenjie.xu.Topic;
import com.wenjie.xu.entry.SwitchStatus;
import com.wenjie.xu.entry.SwitchStatusEntry;
import com.wenjie.xu.kafka.PushKafka;

public class SwitchState implements Runnable{
	private static final Logger logger = LoggerFactory.getLogger(SwitchState.class);
	private Map<String, List<Map<String, String>>> data;
	private Topic topic;
	public SwitchState(Topic topic,Map<String, List<Map<String, String>>> data){
		this.data = data;
		this.topic = topic;
	}
	@Override
	public void run() {
		logger.info("ddddddddddddddddddd");
		if(data==null||data.size()<=0) return;
		List<SwitchStatusEntry> list = new ArrayList<SwitchStatusEntry>();
		SwitchStatusEntry entry = null;
		SwitchStatus switchStatus = null;
		for(String key : data.keySet()){
			for(Map<String, String> mp : data.get(key)){
				//FIXME: 对应数据 修改
				entry = new SwitchStatusEntry();
				entry.setMsgId(mp.get("msgId"));
				entry.setTimeStamp("timeStamp");
				switchStatus = new SwitchStatus();
				switchStatus.setCurrentState("currentState");
				switchStatus.setmRId("mRId");
				switchStatus.setTime("time");
				switchStatus.setValue("value");
				entry.setSwitchStatus(switchStatus);
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
