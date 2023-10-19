package com.gudratli.springbootkafka.config;

import com.gudratli.springbootkafka.enums.EKafkaTopic;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * @author : Dunay Gudratli
 * @mailto : d.qudretli@gmail.com
 * @since : 13.10.2023
 **/
@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic exampleTopic() {
        return TopicBuilder
                .name(EKafkaTopic.EXAMPLE.name())
                .partitions(10)
                .build();
    }

    @Bean
    public NewTopic jsonTopic() {
        return TopicBuilder
                .name(EKafkaTopic.JSON.name())
                .partitions(10)
                .build();
    }
}
