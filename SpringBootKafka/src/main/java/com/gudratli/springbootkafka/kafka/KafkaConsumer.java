package com.gudratli.springbootkafka.kafka;

import com.gudratli.springbootkafka.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @author : Dunay Gudratli
 * @mailto : d.qudretli@gmail.com
 * @since : 13.10.2023
 **/
@Service
@Slf4j
@RequiredArgsConstructor
@PropertySource("classpath:application.yaml")
public class KafkaConsumer {

    @KafkaListener(topics = "EXAMPLE", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String message) {
        log.info("Message accepted: {}", message);
    }

    @KafkaListener(topics = "JSON", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(User data) {
        log.info("Message accepted: {}", data);
    }
}
