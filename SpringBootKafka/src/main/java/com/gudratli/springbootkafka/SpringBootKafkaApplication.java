package com.gudratli.springbootkafka;

import com.gudratli.springbootkafka.wikimedia.kafka.WikimediaChangesProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootKafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootKafkaApplication.class, args);
    }

    @Bean
    public CommandLineRunner run (WikimediaChangesProducer producer)
    {
        return args ->
        {
            producer.sendMessage();
        };
    }
}
