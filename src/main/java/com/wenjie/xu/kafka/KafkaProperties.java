package com.wenjie.xu.kafka;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KafkaProperties {
	private static final Logger logger = LoggerFactory.getLogger(KafkaProperties.class);
	private static final Properties producerProperties = new Properties();
	private static final Properties consumerProperties = new Properties();
	static{
		try {
			producerProperties.load(KafkaProperties.class.getClassLoader().getResourceAsStream("KafkaProducerProperties.properties"));
		} catch (IOException e) {
			logger.error(e.getLocalizedMessage(),e);
		}
		try {
			consumerProperties.load(KafkaProperties.class.getClassLoader().getResourceAsStream("KafkaConsumerProperties.properties"));
		} catch (IOException e) {
			logger.error(e.getLocalizedMessage(),e);
		}
	}
	public static Properties getProducerProperties() {
		return producerProperties;
	}
	public static Properties getConsumerProperties() {
		return consumerProperties;
	}
}
