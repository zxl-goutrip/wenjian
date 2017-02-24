package com.gome.redline.config;

/**
 * zhuxuanlin 2017/2/22 19:44
 * Kafka可配置接口
 */
public interface Configurable {
    /**
     * Kafka配置初始化
     * @return
     */
    public KafkaConfig initConfig();
}
