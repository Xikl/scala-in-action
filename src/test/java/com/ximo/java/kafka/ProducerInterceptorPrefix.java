package com.ximo.java.kafka;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author xikl
 * @date 2021/4/7
 */
public class ProducerInterceptorPrefix implements ProducerInterceptor<String, String> {

    private AtomicLong successCounter = new AtomicLong(0);

    private AtomicLong errorCounter = new AtomicLong(0);

    @Override
    public ProducerRecord<String, String> onSend(ProducerRecord<String, String> record) {
        String valueWithPrefix = String.format("some-prefix-%s", record.value());
        return new ProducerRecord<>(record.topic(),
                record.partition(),
                record.timestamp(),
                record.key(),
                valueWithPrefix,
                record.headers()
        );
    }

    @Override
    public void onAcknowledgement(RecordMetadata metadata, Exception exception) {
        if (exception == null) {
            successCounter.getAndIncrement();
        } else {
            errorCounter.getAndIncrement();
        }
    }

    @Override
    public void close() {
        double successRatio =
                (double) successCounter.get() / (successCounter.get() + errorCounter.get());

        System.out.println("successRatio: " + successRatio);
    }

    @Override
    public void configure(Map<String, ?> configs) {

    }
}
