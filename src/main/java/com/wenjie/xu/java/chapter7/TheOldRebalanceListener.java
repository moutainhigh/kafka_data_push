package com.wenjie.xu.java.chapter7;

import org.apache.kafka.clients.consumer.ConsumerRebalanceListener;
import org.apache.kafka.common.TopicPartition;

import java.util.Collection;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by 朱小厮 on 2019-03-02.
 */
@Slf4j
public class TheOldRebalanceListener implements ConsumerRebalanceListener {
    @Override
    public void onPartitionsRevoked(Collection<TopicPartition> partitions) {
        for (TopicPartition topicPartition : partitions) {
//            commitOffsets(partition);
//            cleanupState(partition);
        	log.info(topicPartition.toString());
        }
    }

    @Override
    public void onPartitionsAssigned(Collection<TopicPartition> partitions) {
        for (TopicPartition topicPartition : partitions) {
//            initializeState(partition)；
//            initializeOffset(partition);
        	log.info(topicPartition.toString());
        }
    }
}
