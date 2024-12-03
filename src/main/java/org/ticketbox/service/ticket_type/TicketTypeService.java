package org.ticketbox.service.ticket_type;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.ticketbox.database.model.Event;
import org.ticketbox.database.model.TicketType;
import org.ticketbox.database.repository.EventRepository;
import org.ticketbox.database.repository.TicketTypeRepository;
import org.ticketbox.service.kafka.KafkaProducerService;
import org.ticketbox.shared.constant.ErrorCodeConstant;
import org.ticketbox.shared.dto.ticket_type.CreateTicketTypeDto;
import org.ticketbox.shared.exception.custom.BadRequestException;
import org.ticketbox.shared.type.TicketTypeSummary;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TicketTypeService {
    private static final Logger log = LoggerFactory.getLogger(TicketTypeService.class.getSimpleName());
    private final KafkaProducerService kafkaProducerService;
    private TicketTypeRepository ticketTypeRepository;
    private EventRepository eventRepository;

    public List<TicketType> getTicketTypesByEvent(Integer eventId) {
        return ticketTypeRepository.findByEventId(eventId);
    }

    public TicketType createTicketType(CreateTicketTypeDto ticketTypeDto) {
        Event event = eventRepository.getEventById(ticketTypeDto.getEventId())
                .orElseThrow(() -> new BadRequestException(ErrorCodeConstant.EVENT_NOT_EXIST));

        TicketType ticketType = new TicketType();
        ticketType.setName(ticketTypeDto.getName());
        ticketType.setPrice(ticketTypeDto.getPrice());
        ticketType.setDescription(ticketTypeDto.getDescription());
        ticketType.setAmount(ticketTypeDto.getAmount());
        ticketType.setEvent(event);

        TicketType newTicketType = ticketTypeRepository.save(ticketType);

        String topic = "create_ticket_type";
        TicketTypeSummary ticketTypeSummary = TicketTypeSummary.builder().ticketTypeId(newTicketType.getId()).eventId(event.getId()).amount(newTicketType.getAmount()).build();
        kafkaProducerService.sendMessage(topic, ticketTypeSummary);
        log.info("Send message create Ticket Type to topic: " + topic + "And the message data: " + ticketTypeSummary);

        return ticketType;
    }

    public TicketType editTicketType(Integer id, CreateTicketTypeDto ticketTypeDto) {
        TicketType ticketType = ticketTypeRepository.getTicketTypeById(id)
                .orElseThrow(() -> new BadRequestException(ErrorCodeConstant.TICKET_TYPE_NOT_EXIST));

        Event event = eventRepository.getEventById(ticketTypeDto.getEventId())
                .orElseThrow(() -> new BadRequestException(ErrorCodeConstant.EVENT_NOT_EXIST));

        ticketType.setName(ticketTypeDto.getName());
        ticketType.setPrice(ticketTypeDto.getPrice());
        ticketType.setDescription(ticketTypeDto.getDescription());
        ticketType.setAmount(ticketTypeDto.getAmount());
        ticketType.setEvent(event);

        TicketType editedTicketType = ticketTypeRepository.save(ticketType);

        String topic = "edit_ticket_type";
        TicketTypeSummary ticketTypeSummary = TicketTypeSummary.builder().ticketTypeId(editedTicketType.getId()).eventId(event.getId()).amount(editedTicketType.getAmount()).build();
        kafkaProducerService.sendMessage(topic, ticketTypeSummary);
        log.info("Send message edit Ticket Type to topic: " + topic + "And the message data: " + ticketTypeSummary);

        return editedTicketType;
    }

    public Optional<TicketType> getTicketTypeById(Integer id) {
        return ticketTypeRepository.getTicketTypeById(id);
    }

    public void deleteTicketTypeById(Integer id) {
        ticketTypeRepository.deleteById(id);
        String topic = "delete_ticket_type";
        kafkaProducerService.sendMessage(topic, id);
        log.info("Send message delete Ticket Type to topic: " + topic + "And the message data: " + id);
    }
}
