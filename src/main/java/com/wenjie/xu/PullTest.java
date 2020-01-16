package com.wenjie.xu;

import com.wenjie.xu.kafka.PushKafka;

public class PullTest {
	public static void main(String[] args) {
		String topic = Topic.ZT_DMS_CBSTATUS.getId();
		if(args!=null && args.length>0){
			try {
				topic = args[0];
			} catch (Exception e) {
			}
		}
		PushKafka.pull(topic);
	}
}
