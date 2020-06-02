package com.ximo.java.kafka;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.common.errors.RetriableException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Properties;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

/**
 * 需要修改 vim config/server.properties 中的 advertised.listeners
 *
 * @author xikl
 * @date 2020/4/20
 */
public class KafkaProducerTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testKafkaProducer() {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "192.168.85.128:9092");
        //此配置是 Producer 在确认一个请求发送完成之前需要收到的反馈信息的数量。 这个参数是为了保证发送请求的可靠性。以下配置方式是允许的：
        //acks=0 如果设置为0，则 producer 不会等待服务器的反馈。该消息会被立刻添加到 socket buffer 中并认为已经发送完成。在这种情况下，服务器是否收到请求是没法保证的，并且参数retries也不会生效（因为客户端无法获得失败信息）。每个记录返回的 offset 总是被设置为-1。
        //acks=1 如果设置为1，leader节点会将记录写入本地日志，并且在所有 follower 节点反馈之前就先确认成功。在这种情况下，如果 leader 节点在接收记录之后，并且在 follower 节点复制数据完成之前产生错误，则这条记录会丢失。
        //acks=all 如果设置为all，这就意味着 leader 节点会等待所有同步中的副本确认之后再确认这条记录是否发送完成。只要至少有一个同步副本存在，记录就不会丢失。这种方式是对请求传递的最有效保证。acks=-1与acks=all是等效的
        properties.put("acks", "all");
        // 默认为0 如果不设置 那就将直接失败
        properties.put("retries", 0);
        // 默认就是该值
        properties.put("batch.size", 16384);
        // 逗留时间
        properties.put("linger.ms", 1);
        // 默认值
        properties.put("buffer.memory", 33554432);
        // 指定分区
        properties.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, "com.ximo.java.kafka.AuditPartitioner");

        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        // 它可以自动关闭 故可以改成这种 try resources的写法
        try (Producer<String, String> producer = new KafkaProducer<>(properties)) {
            for (int index = 0; index < 10; index++) {
                final String key = Integer.toString(index);
                final String value = key;
                final ProducerRecord<String, String> record = new ProducerRecord<>(
                        "zwz_test",
                        key,
                        value
                );
                producer.send(record, (metadata, exception) -> {
                    if (exception == null) {
                        // 发送成功
                    } else {
                        if (exception instanceof RetriableException) {
                            // 可重试异常
                        } else {
                            // 不可重试异常
                        }
                    }
                });
            }
        }
    }
}