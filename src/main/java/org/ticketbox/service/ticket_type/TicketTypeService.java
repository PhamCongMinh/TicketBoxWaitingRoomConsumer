package org.ticketbox.service.ticket_type;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ticketbox.database.model.TicketType;
import org.ticketbox.database.repository.TicketTypeRepository;
import org.ticketbox.service.kafka.KafkaProducerService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketTypeService {
    @Autowired
    private TicketTypeRepository ticketTypeRepository;
    private final KafkaProducerService kafkaProducerService;
    private static final Logger log = LoggerFactory.getLogger(TicketTypeService.class.getSimpleName());

    public List<TicketType> getTicketTypesByEvent(Integer eventId) {
        return ticketTypeRepository.findByEventId(eventId);
    }

    public TicketType createTicketType(TicketType ticketType) {
        TicketType newTicketType = ticketTypeRepository.save(ticketType);
        String topic = "create_ticket_type";
        String testMessage = "test";
        kafkaProducerService.sendMessage(topic, testMessage);
        log.info("Send message create Ticket Type to topic: " + topic);
        return newTicketType;
    }

//    public Event editTicketType(Integer id, Event event) {
//
//    }

    public TicketType getTicketTypeById(Integer id) {
        return ticketTypeRepository.getTicketTypeById(id);
    }

    public void deleteTicketTypeById(Integer id) {
        ticketTypeRepository.deleteById(id);
        String topic = "delete_ticket_type";
        String testMessage = "test";
        kafkaProducerService.sendMessage(topic, testMessage);
        log.info("Send message delete Ticket Type to topic: " + topic);
    }
}
