package org.ticketbox.service.ticket_type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ticketbox.database.model.Event;
import org.ticketbox.database.model.TicketType;
import org.ticketbox.database.repository.EventRepository;
import org.ticketbox.database.repository.TicketTypeRepository;
import org.ticketbox.shared.constant.ErrorCodeConstant;
import org.ticketbox.shared.exception.custom.BadRequestException;

import java.util.List;
import java.util.Optional;

@Service
public class TicketTypeService {
    @Autowired
    private TicketTypeRepository ticketTypeRepository;

    public List<TicketType> getTicketTypesByEvent(Integer eventId) {
        return ticketTypeRepository.findByEventId(eventId);
    }

    public TicketType createTicketType(TicketType ticketType) {
        return ticketTypeRepository.save(ticketType);
    }

//    public Event editTicketType(Integer id, Event event) {
//
//    }

    public TicketType getTicketTypeById(Integer id) {
        return ticketTypeRepository.getTicketTypeById(id);
    }

    public void deleteTicketTypeById(Integer id) {
        ticketTypeRepository.deleteById(id);
    }
}
