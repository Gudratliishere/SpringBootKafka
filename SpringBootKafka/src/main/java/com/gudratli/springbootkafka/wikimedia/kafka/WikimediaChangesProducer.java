package com.gudratli.springbootkafka.wikimedia.kafka;

import com.gudratli.springbootkafka.wikimedia.enums.EKafkaTopic;
import com.gudratli.springbootkafka.wikimedia.handler.WikimediaChangesHandler;
import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

/**
 * @author : Dunay Gudratli
 * @mailto : d.qudretli@gmail.com
 * @since : 17.10.2023
 **/
@Service
@Slf4j
@RequiredArgsConstructor
public class WikimediaChangesProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage() throws InterruptedException {
        String topic = EKafkaTopic.WIKIMEDIA_RECENTCHANGE.getData();

        EventHandler eventHandler = new WikimediaChangesHandler(kafkaTemplate, topic);
        String url = "https://stream.wikimedia.org/v2/stream/recentchange";
        EventSource.Builder builder = new EventSource.Builder(eventHandler, URI.create(url));
        EventSource eventSource = builder.build();
        eventSource.start();
        TimeUnit.MINUTES.sleep(10);
        eventSource.close();
    }
}
