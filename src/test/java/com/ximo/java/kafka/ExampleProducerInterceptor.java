package com.ximo.java.kafka;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Map;

/**
 * @author xikl
 * @date 2020/6/8
 */
public class ExampleProducerInterceptor implements ProducerInterceptor<String, String> {


    @Override
    public void configure(Map<String, ?> configs) {

    }

    @Override
    public ProducerRecord<String, String> onSend(ProducerRecord<String, String> record) {
        final String topic = record.topic();
        final Integer partition = record.partition();
        final Long timestamp = record.timestamp();
        final String key = record.key();
        final String value = record.value();
        String newValue = System.currentTimeMillis() + "," + value;

        return new ProducerRecord<>(
                topic,
                partition,
                timestamp,
                key,
                newValue
        );
    }

    @Override
    public void onAcknowledgement(RecordMetadata metadata, Exception exception) {
//        log.error("metadata: {}", metadata, exception);
    }

    @Override
    public void close() {

    }

}
