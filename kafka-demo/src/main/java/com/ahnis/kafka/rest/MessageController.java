package com.ahnis.kafka.rest;

import com.ahnis.kafka.payload.Student;
import com.ahnis.kafka.producer.KafkaJsonProducer;
import com.ahnis.kafka.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/v1/messages")
@RequiredArgsConstructor
public class MessageController {
    private final KafkaProducer kafkaProducer;
    private final KafkaJsonProducer kafkaJsonProducer;

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody String message) {
        kafkaProducer.sendMessage(message);

        return ResponseEntity.ok("Mesage queued succesfully");
    }

    @PostMapping("/json")
    public ResponseEntity<String> sendJsonMessage(@RequestBody Student student) {
        kafkaJsonProducer.sendMessage(student);

        return ResponseEntity.ok("Json message queued succesfully");
    }
}
