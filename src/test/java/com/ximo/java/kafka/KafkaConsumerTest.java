package com.ximo.java.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.junit.Test;

import java.util.Arrays;
import java.util.Properties;

/**
 * @author xikl
 * @date 2020/4/26
 */
public class KafkaConsumerTest {

    /**
     * 查看消费者组的信息
     * ./kafka-consumer-groups.sh --bootstrap-server localhost:9092 --describe --group zwz_test_group
     *
     * 查看最大值
     * ./kafka-run-class.sh kafka.tools.GetOffsetShell --broker-list localhost:9092 --topic zwz_test --time -1
     *
     * 查看最小值
     * ./kafka-run-class.sh kafka.tools.GetOffsetShell --broker-list localhost:9092 --topic zwz_test --time -2
     *
     */
    @Test
    public void testConsumer() {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "192.168.85.128:9092");
        properties.put("group.id", "zwz_test_group");
        properties.put("enable.auto.commit", true);
        properties.put("auto.commit.interval.ms", "1000");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);
        consumer.subscribe(Arrays.asList("zwz_test"));
        for (; ; ) {
            final ConsumerRecords<String, String> consumerRecords = consumer.poll(100);
            for (ConsumerRecord<String, String> consumerRecord : consumerRecords) {
                System.out.printf("offset = %d, key = %s, value = %s%n", consumerRecord.offset(),
                        consumerRecord.key(), consumerRecord.value());
            }
        }


    }
}
