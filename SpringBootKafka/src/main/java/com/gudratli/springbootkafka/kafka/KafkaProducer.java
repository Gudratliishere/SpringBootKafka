package com.gudratli.springbootkafka.kafka;

import com.gudratli.springbootkafka.enums.EKafkaTopic;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @author : Dunay Gudratli
 * @mailto : d.qudretli@gmail.com
 * @since : 13.10.2023
 **/
@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        log.info("Message sent {}", message);
        kafkaTemplate.send(EKafkaTopic.EXAMPLE.name(), message);
    }
}
