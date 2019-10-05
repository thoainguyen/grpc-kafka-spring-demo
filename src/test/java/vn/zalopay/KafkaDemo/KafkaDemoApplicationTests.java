package vn.zalopay.KafkaDemo;


import static org.assertj.core.api.Assertions.assertThat;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import vn.zalopay.KafkaDemo.kafka.KafkaConsumer;
import vn.zalopay.KafkaDemo.kafka.KafkaProducer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KafkaDemoApplicationTests {

    @Autowired
    private KafkaProducer sender;

    @Autowired
    private KafkaConsumer receiver;

    @Test
    public void testReceiver() throws Exception {
        sender.sendMessage("helloworld.t", "Hello Spring Kafka!");

        receiver.getLatch().await(5000, TimeUnit.MILLISECONDS);
        assertThat(receiver.getLatch().getCount()).isEqualTo(0);
    }
}