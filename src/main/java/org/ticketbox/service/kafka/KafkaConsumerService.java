package org.ticketbox.service.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.ticketbox.shared.type.WaitingRoomMessage;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "create_ticket_type", groupId = "my-group")
    public void listenMessageForTicketType(WaitingRoomMessage waitingRoomMessage) {
        System.out.println("Received Message: " + waitingRoomMessage);
    }
}
