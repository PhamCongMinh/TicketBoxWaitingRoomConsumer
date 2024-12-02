package org.ticketbox.service.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ticketbox.database.model.Event;
import org.ticketbox.database.repository.EventRepository;
import org.ticketbox.shared.constant.ErrorCodeConstant;
import org.ticketbox.shared.exception.custom.BadRequestException;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAllEvent() {
        return eventRepository.findAll();
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event editEvent(Integer id, Event event) {
        Optional<Event> isExist = eventRepository.findById(id);

        if (isExist.isEmpty())
            throw new BadRequestException(ErrorCodeConstant.EVENT_NOT_EXIST);

        // TODO: Fix this
        return eventRepository.save(event);
    }

    public Event getDetailEventById(Integer id) {
        return eventRepository.getEventById(id);
    }

    public void deleteEventById(Integer id) {
        eventRepository.deleteById(id);
    }
}
