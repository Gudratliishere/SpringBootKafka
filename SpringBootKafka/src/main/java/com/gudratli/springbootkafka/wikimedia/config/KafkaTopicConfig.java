package com.gudratli.springbootkafka.wikimedia.config;

import com.gudratli.springbootkafka.wikimedia.enums.EKafkaTopic;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * @author : Dunay Gudratli
 * @mailto : d.qudretli@gmail.com
 * @since : 17.10.2023
 **/
@Configuration("wikimediaKafkaTopicConfig")
public class KafkaTopicConfig {

    @Bean
    public NewTopic topic() {
        return TopicBuilder.name(EKafkaTopic.WIKIMEDIA_RECENTCHANGE.getData())
                .build();
    }
}
