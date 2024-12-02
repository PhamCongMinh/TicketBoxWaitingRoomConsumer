package org.ticketbox.controller.test_kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.ticketbox.service.kafka.KafkaProducerService;

@RestController
@RequiredArgsConstructor
public class KafkaController {

    private final KafkaProducerService kafkaProducerService;

    @GetMapping("/send")
    public String sendMessage(@RequestParam String topic, @RequestParam String message) {
        kafkaProducerService.sendMessage(topic, message);
        return "Message sent to topic: " + topic;
    }
}
