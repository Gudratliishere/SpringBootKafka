package com.gudratli.springbootkafka.controller;

import com.gudratli.springbootkafka.kafka.JsonKafkaProducer;
import com.gudratli.springbootkafka.kafka.KafkaProducer;
import com.gudratli.springbootkafka.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author : Dunay Gudratli
 * @mailto : d.qudretli@gmail.com
 * @since : 13.10.2023
 **/
@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
public class MessageController {
    private final KafkaProducer kafkaProducer;
    private final JsonKafkaProducer jsonKafkaProducer;

    @PostMapping
    public ResponseEntity<String> sendMessage (@RequestParam String message)
    {
        kafkaProducer.sendMessage(message);

        return ResponseEntity.ok("Message sent successfully.");
    }

    @PostMapping("/sendModel")
    public ResponseEntity<String> sendMessage (@RequestBody User user)
    {
        jsonKafkaProducer.sendMessage(user);

        return ResponseEntity.ok("Model sent successfully.");
    }
}
