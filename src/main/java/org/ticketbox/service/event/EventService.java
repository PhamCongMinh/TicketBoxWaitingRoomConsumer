package org.ticketbox.service.event;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.ticketbox.database.model.Event;
import org.ticketbox.database.model.Organizer;
import org.ticketbox.database.repository.EventRepository;
import org.ticketbox.database.repository.OrganizerRepository;
import org.ticketbox.shared.constant.ErrorCodeConstant;
import org.ticketbox.shared.dto.event.CreateEventDto;
import org.ticketbox.shared.exception.custom.BadRequestException;

import java.util.List;

@Service
@AllArgsConstructor
public class EventService {
    private EventRepository eventRepository;
    private OrganizerRepository organizerRepository;

    public List<Event> getAllEvent() {
        return eventRepository.findAll();
    }

    public Event createEvent(CreateEventDto eventDto) {
        Organizer organizer = organizerRepository.getOrganizerById(eventDto.getOrganizerId())
                .orElseThrow(() -> new BadRequestException(ErrorCodeConstant.ORGANIZER_NOT_EXIST));

        Event event = new Event();
        event.setName(eventDto.getName());
        event.setBackgroundImageUrl(eventDto.getBackgroundImageUrl());
        event.setStartTime(eventDto.getStartTime());
        event.setEndTime(eventDto.getEndTime());
        event.setLocation(eventDto.getLocation());
        event.setDescription(eventDto.getDescription());
        event.setStatus(eventDto.getStatus());
        event.setOrganizer(organizer);
        return eventRepository.save(event);
    }

    public Event editEvent(Integer id, CreateEventDto eventDto) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new BadRequestException(ErrorCodeConstant.EVENT_NOT_EXIST));

        Organizer organizer = organizerRepository.getOrganizerById(eventDto.getOrganizerId())
                .orElseThrow(() -> new BadRequestException(ErrorCodeConstant.ORGANIZER_NOT_EXIST));

        event.setName(eventDto.getName());
        event.setBackgroundImageUrl(eventDto.getBackgroundImageUrl());
        event.setStartTime(eventDto.getStartTime());
        event.setEndTime(eventDto.getEndTime());
        event.setLocation(eventDto.getLocation());
        event.setDescription(eventDto.getDescription());
        event.setStatus(eventDto.getStatus());
        event.setOrganizer(organizer);

        return eventRepository.save(event);
    }

    public Event getDetailEventById(Integer id) {
        return eventRepository.getEventById(id)
                .orElseThrow(() -> new BadRequestException(ErrorCodeConstant.EVENT_NOT_EXIST));
    }

    public void deleteEventById(Integer id) {
        eventRepository.deleteById(id);
    }
}
