package com.gome.redline.test;

import com.gome.redline.encoder.IKafkaMessageEncoder;
import com.gome.redline.encoder.KafkaMessageStringEncoder;
import com.gome.redline.pool.KafkaProducerPool;
import com.gome.redline.producer.IKafkaProducer;
import java.util.Map;

/**
 * Created by zhuxuanlin at 2017/2/23 14:36
 * Kafka Producer Test
 */
public class ProducerTest {
    public static void main(String[] args ) {
        String topic = "test-topic";
        KafkaProducerPool producerPool = new KafkaProducerPool(topic);
        IKafkaProducer producer = producerPool.getProducer();
        if(null == producer) {
            System.out.println("take a kafka producer from Kafka Pool,but it is null.");
            return;
        }
        String message = "2017-02-23 15:09 test message111.";
        IKafkaMessageEncoder encoder = new KafkaMessageStringEncoder();
        producer.send(message,encoder);
        System.out.println("Producer send kafka message have finished.");
        //将Kafka生产者归还到Kafka Pool中
        producerPool.returnProducer(producer);
        producerPool.close();
    }
}
