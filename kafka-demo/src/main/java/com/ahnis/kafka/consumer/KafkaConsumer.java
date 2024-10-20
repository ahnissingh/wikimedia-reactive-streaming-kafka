package com.ahnis.kafka.consumer;

import com.ahnis.kafka.payload.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {
    //    @KafkaListener(topics = "ahnis", groupId = "myGroup")
//    public void consumeMessage(String message) {
//        log.info(String.format("Consuming the message from ahnis topic :: %s", message));
//    }
    @KafkaListener(topics = "ahnis", groupId = "myGroup")
    public void consumeJsonMessage(Student student) {
        log.info(String.format("Consuming the message from ahnis topic :: %s", student.toString()));
    }
}
