package com.gudratli.springbootkafka.kafka;

import com.gudratli.springbootkafka.enums.EKafkaTopic;
import com.gudratli.springbootkafka.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * @author : Dunay Gudratli
 * @mailto : d.qudretli@gmail.com
 * @since : 13.10.2023
 **/
@Service
@Slf4j
@RequiredArgsConstructor
public class JsonKafkaProducer {
    private final KafkaTemplate<String, User> kafkaTemplate;

    public <T> void sendMessage(T data) {
        log.info("Data has been sent: {}", data);

        Message<T> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, EKafkaTopic.JSON.name())
                .build();

        kafkaTemplate.send(message);
    }
}
