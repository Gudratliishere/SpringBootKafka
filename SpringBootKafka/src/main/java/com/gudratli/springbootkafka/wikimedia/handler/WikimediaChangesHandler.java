package com.gudratli.springbootkafka.wikimedia.handler;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * @author : Dunay Gudratli
 * @mailto : d.qudretli@gmail.com
 * @since : 17.10.2023
 **/
@Slf4j
@RequiredArgsConstructor
public class WikimediaChangesHandler implements EventHandler {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final String topic;


    @Override
    public void onOpen() {

    }

    @Override
    public void onClosed() {

    }

    @Override
    public void onMessage(String s, MessageEvent messageEvent) {
        log.info("PRODUCER: Message accepted s -> {} \nMessage -> {}", s, messageEvent.getData());

        kafkaTemplate.send(topic, messageEvent.getData());
    }

    @Override
    public void onComment(String s) {

    }

    @Override
    public void onError(Throwable throwable) {

    }
}
