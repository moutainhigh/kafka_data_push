package com.wenjie.xu.java.chapter3;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * 代码清单3-2
 * Created by 朱小厮 on 2018/7/28.
 */
public class CheckOffsetAndPosition {
    public static final String brokerList = "localhost:9092";
    public static final String topic = "topic-demo";
    public static final String groupId = "group.demo";

    public static Properties initConfig() {
        Properties props = new Properties();
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class.getName());
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerList);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        return props;
    }

    public static void main(String[] args) {
        Properties props = initConfig();
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);


        TopicPartition tp = new TopicPartition(topic, 0);
        consumer.assign(Arrays.asList(tp));
        long lastConsumedOffset = -1;
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
            if (records.isEmpty()) {
                break;
            }
            List<ConsumerRecord<String, String>> partitionRecords
                    = records.records(tp);
            lastConsumedOffset = partitionRecords
                    .get(partitionRecords.size() - 1).offset();
            consumer.commitSync();//同步提交消费位移
        }
        System.out.println("comsumed offset is " + lastConsumedOffset);
        OffsetAndMetadata offsetAndMetadata = consumer.committed(tp);
        System.out.println("commited offset is " + offsetAndMetadata.offset());
        long posititon = consumer.position(tp);
        System.out.println("the offset of the next record is " + posititon);
        consumer.close();
    }
}
