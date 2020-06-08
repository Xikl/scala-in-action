package com.ximo.java.kafka;

import org.apache.kafka.common.serialization.Serializer;

import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * @author xikl
 * @date 2020/6/8
 */
public class ExampleSerializer implements Serializer<String> {


    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public byte[] serialize(String topic, String data) {
        // 比如自己实现一个自定义的类 来搞定
//        return data.getBytes(StandardCharsets.UTF_8);
        return new byte[0];
    }

    @Override
    public void close() {

    }
}
