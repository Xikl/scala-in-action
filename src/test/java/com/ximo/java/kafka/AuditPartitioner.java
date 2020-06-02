package com.ximo.java.kafka;

import org.apache.commons.lang3.StringUtils;
import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import org.apache.kafka.common.PartitionInfo;

import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author xikl
 * @date 2020/6/2
 */
public class AuditPartitioner implements Partitioner {

    private ThreadLocal<Random> random;

    @Override
    public void configure(Map<String, ?> configs) {
        random = ThreadLocal.withInitial(Random::new);
    }

    @Override
    public int partition(String topic,
                         Object key,
                         byte[] keyBytes,
                         Object value,
                         byte[] valueBytes,
                         Cluster cluster) {
        String keyStringValue = (String) key;
        final List<PartitionInfo> partitionInfoList = cluster.availablePartitionsForTopic(topic);
        final int partitionCount = partitionInfoList.size();
        int auditPartition = partitionCount - 1;
        return StringUtils.isEmpty(keyStringValue) ? random.get().nextInt(partitionCount - 1) : auditPartition;
    }

    @Override
    public void close() {
        // 关闭资源
    }
}
