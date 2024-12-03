package org.ticketbox.service.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.ticketbox.shared.type.TicketTypeSummary;

@Service
@RequiredArgsConstructor
public class KafkaProducerService {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessageForTicketType(String topic, TicketTypeSummary ticketTypeSummary) {
        kafkaTemplate.send(topic, ticketTypeSummary);
    }
}

