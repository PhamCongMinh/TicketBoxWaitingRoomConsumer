package org.ticketbox.service.wating_room;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.ticketbox.database.repository.WaitingRoomSettingRepository;
import org.ticketbox.service.kafka.KafkaProducerService;
import org.ticketbox.shared.dto.waiting_room.JoinWaitingRoomDto;
import org.ticketbox.shared.type.WaitingRoomMessage;

@Service
@AllArgsConstructor
public class WaitingRoomService {
    private static final Logger log = LoggerFactory.getLogger(WaitingRoomService.class.getSimpleName());

    private WaitingRoomSettingRepository waitingRoomSettingRepository;
    private final KafkaProducerService kafkaProducerService;

    public String checkAndGetQueueNum(JoinWaitingRoomDto joinWaitingRoomDto) {
        String topic = "waiting_room";
        WaitingRoomMessage waitingRoomMessage = WaitingRoomMessage.builder().eventId(joinWaitingRoomDto.getEventId()).userId(joinWaitingRoomDto.getUserId()).build();
        kafkaProducerService.sendMessage(topic, waitingRoomMessage);
        log.info("Send message to topic: " + topic + "And the message data: " + waitingRoomMessage);
        return "Test";
    }
}
