package com.ximo.java.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.errors.WakeupException;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.junit.Test;

import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

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
        // 自动提交，对于一些需要精确一次的处理语义，应该将其置为false，自己来决定是否提交
        properties.put("enable.auto.commit", true);
        // 消费者多长时间提交给zk
        properties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
        // 从最早的消息开始读取
        properties.put("auto.offset.reset", "earliest");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        // 默认十秒
//        ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG rebalance
//        ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG 处理逻辑的最大处理时间
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);
        // 订阅 topic
        // 如果调用多次 subscribe 那么将会用最新的列表
        // org.apache.kafka.clients.consumer.ConsumerRebalanceListener 重平衡
        consumer.subscribe(Arrays.asList("zwz_test"));
        // 订阅所有的kafka的开头的数据
//        consumer.subscribe(Pattern.compile("kakaf-.*"));

//        TopicPartition topicPartition = new TopicPartition("zwz_test", 0);
//        consumer.assign(Arrays.asList(topicPartition));
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

    @Test
    public void testAssignAndSubscribe() {
//        https://blog.csdn.net/weixin_34281537/article/details/91392024

    }

    @Test
    public void testKafkaConsumerMultiThreadUnsafe() {
        // kafka 不支持多线程调用
        // 每一个方法里都有一个acquire方法判断当前线程是否一致是否没有线程调用

    }

    @Test
    public void testKafkaConsumerWakeupException() {
        Properties properties = new Properties();

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties, new StringDeserializer(), new StringDeserializer());
        // other consumer
        CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.MINUTES.sleep(2);
                consumer.wakeup();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        try {
            while (true) {
                // 不推荐将繁重的操作放到for循环处理消息中
                final ConsumerRecords<String, String> consumerRecords = consumer.poll(Long.MAX_VALUE);
                for (ConsumerRecord<String, String> consumerRecord : consumerRecords) {
                    System.out.printf("topic = %s, partition = %d, offset = %d", consumerRecord.topic(),
                            consumerRecord.partition(), consumerRecord.offset());
                }
            }
        } catch (WakeupException e) {
            // 忽略此异常信息
            e.printStackTrace();
        } finally {
            consumer.close();
        }




    }
}
