package com.gudratli.springbootkafka.wikimedia.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @author : Dunay Gudratli
 * @mailto : d.qudretli@gmail.com
 * @since : 19.10.2023
 **/
@Service
@Slf4j
public class WikimediaKafkaConsumer {

    @KafkaListener(topics = "wikimedia_recent_change", groupId = "myGroup")
    public void consume(String eventMessage) {
        log.info("CONSUMER: Message accepted -> {}", eventMessage);
    }
}
