package com.wenjie.xu.parse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.wenjie.xu.Topic;
import com.wenjie.xu.entry.SOEEntry;
import com.wenjie.xu.entry.SOEInfo;
import com.wenjie.xu.kafka.PushKafka;

public class SOE implements Runnable{
	private static final Logger logger = LoggerFactory.getLogger(SOE.class);
	private Map<String, List<Map<String, String>>> data;
	private Topic topic;
	public SOE(Topic topic,Map<String, List<Map<String, String>>> data){
		this.data = data;
		this.topic = topic;
	}
	@Override
	public void run() {
		if(data==null||data.size()<=0) return;
		List<SOEEntry> list = new ArrayList<SOEEntry>();
		SOEEntry entry = null;
		SOEInfo sOEInfo = null;
		for(String key : data.keySet()){
			for(Map<String, String> mp : data.get(key)){
				//FIXME: 对应数据 修改
				entry = new SOEEntry();
				entry.setMsgId(mp.get("msgID"));
				entry.setTimeStamp("timeStamp");
				sOEInfo = new SOEInfo();
				sOEInfo.setmRId("mRId");
				sOEInfo.setSTATUS("sTATUS");
				sOEInfo.setTime("time");
				sOEInfo.setValue("value");
				entry.setSOEInfo(sOEInfo);
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
