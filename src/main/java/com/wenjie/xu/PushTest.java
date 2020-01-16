package com.wenjie.xu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wenjie.xu.kafka.PushKafka;

public class PushTest {
	private static final Logger log = LoggerFactory.getLogger(PushTest.class);
	public static void main(String[] args) {
		String topic = Topic.ZT_DMS_CBSTATUS.getId();
		if(args!=null && args.length>0){
			try {
				topic = args[0];
			} catch (Exception e) {
			}
		}
		try {
			PushKafka.push(topic, "test-data,topic="+topic);
		} catch (Exception e) {
			log.error(e.getLocalizedMessage(),e);
		} 
	}
}
