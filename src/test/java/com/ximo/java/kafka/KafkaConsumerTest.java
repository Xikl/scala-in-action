package com.ximo.java.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
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
     * <p>
     * 查看最大值
     * ./kafka-run-class.sh kafka.tools.GetOffsetShell --broker-list localhost:9092 --topic zwz_test --time -1
     * <p>
     * 查看最小值
     * ./kafka-run-class.sh kafka.tools.GetOffsetShell --broker-list localhost:9092 --topic zwz_test --time -2
     */
    @Test
    public void testConsumer() {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "192.168.85.128:9092");
        // 消费者组
        properties.put("group.id", "zwz_test_group");
        // 自动提交
        properties.put("enable.auto.commit", true);
        // 消费者多长时间提交给zk
        properties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
        // 从最早的消息开始读取
        properties.put("auto.offset.reset", "earliest");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);
        // 订阅 topic
        // 如果调用多次 subscribe 那么将会用最新的列表
        // org.apache.kafka.clients.consumer.ConsumerRebalanceListener 重平衡
        consumer.subscribe(Arrays.asList("zwz_test"));
        try {
            for (; ; ) {
                // poll 参数是 100 代表是超时时间
                // 最多等一秒
                final ConsumerRecords<String, String> consumerRecords = consumer.poll(100);
                for (ConsumerRecord<String, String> consumerRecord : consumerRecords) {
                    System.out.printf("offset = %d, key = %s, value = %s%n", consumerRecord.offset(),
                            consumerRecord.key(), consumerRecord.value());
                }
            }
        } finally {
            consumer.close();
        }
    }

    @Test
    public void test__consumer_offsets() {
        // 神奇的 __consumer_offsets

    }
}
