package com.wenjie.xu.kafka;

import java.time.Duration;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.TopicPartition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PushKafka implements Callback{
	private static final Logger logger = LoggerFactory.getLogger(PushKafka.class);
	public static final AtomicBoolean isRunning = new AtomicBoolean(true);
	@Override
	public void onCompletion(RecordMetadata metadata, Exception exception) {
		if(exception!=null){
			logger.error(exception.getLocalizedMessage(),exception);
		}
	}
	public static void push(String topic,String json) throws InterruptedException, ExecutionException{
		logger.info("send msg is begin");
		Producer<String, String> producer = null;
        try {
            producer = new KafkaProducer<>(KafkaProperties.getProducerProperties());
            //同步发送
            producer.send(new ProducerRecord<String, String>(topic, json)).get();
        }finally {
        	try {
				producer.flush();
			} catch (Exception e) {}
            try {
				producer.close();
			} catch (Exception e) {}
        }
        logger.info("send msg is over");
	}
	public static void pull(String topic){
		KafkaConsumer<String,String> consumer = null;
        try {
        	consumer = new KafkaConsumer<String,String>(KafkaProperties.getConsumerProperties());
        	List<PartitionInfo> pinfos = consumer.partitionsFor(topic);
        	logger.info("topic={},partitionsFor={}",topic,pinfos.size());
        	consumer.subscribe(Collections.singleton(topic));
        	/**
        	 * 使用seek 细粒度掌握位移，指定消费位置
        	 * 必须首先调用poll消费一次 确定消费主题分区
        	 * 一定要确定拿到消费主题分区
        	 */
        	Set<TopicPartition> tps = new HashSet<TopicPartition>();
        	while(tps.size() ==0){
        		consumer.poll(Duration.ofMillis(10000));
        		tps = consumer.assignment();
        	}
        	
        	for(TopicPartition tp : tps){
        		consumer.seek(tp, 0);
        	}
        	while(isRunning.get()){
        		for(ConsumerRecord<String, String> record : consumer.poll(Duration.ofMillis(1000))){
        			logger.info(record.value());
        		}
        	}
        } catch (Exception e) {
        	logger.error(e.getLocalizedMessage(),e);
        } finally {
            try {
            	consumer.close();
			} catch (Exception e) {}
        }
	}
}
