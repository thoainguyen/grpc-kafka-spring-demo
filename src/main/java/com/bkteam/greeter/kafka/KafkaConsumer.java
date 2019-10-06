package com.bkteam.greeter.kafka;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    private CountDownLatch latch = new CountDownLatch(1);


    @KafkaListener(topics = "kafka-demo-group.topic1")
    public void receiveMessage(String message) {
        LOGGER.info("received message='{}'", message);
        System.out.println("received message=" + message);
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }

    public void KafkaConsumer(){}
}