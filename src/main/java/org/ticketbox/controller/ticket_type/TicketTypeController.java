package org.ticketbox.controller.ticket_type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.ticketbox.database.model.Event;
import org.ticketbox.database.model.TicketType;
import org.ticketbox.service.event.EventService;
import org.ticketbox.service.ticket_type.TicketTypeService;
import org.ticketbox.shared.base.BaseResponse;

import java.util.List;

@RestController()
@RequestMapping("/ticket-types")
public class TicketTypeController {
    @Autowired
    private TicketTypeService ticketTypeService;


    @GetMapping("/events/{eventId}")
    public BaseResponse<List<TicketType>> getTicketTypesByEvent(@PathVariable Integer eventId) {
        return new BaseResponse<List<TicketType>>(ticketTypeService.getTicketTypesByEvent(eventId));
    }

    @PostMapping
    public BaseResponse<TicketType> createTicketType(@RequestBody TicketType ticketType) {
        return new BaseResponse<TicketType>(ticketTypeService.createTicketType(ticketType));
    }

    @GetMapping("/{id}")
    public BaseResponse<TicketType> getTicketTypesById(@PathVariable Integer id) {
        return new BaseResponse<TicketType>(ticketTypeService.getTicketTypeById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteTicketTypeById(@PathVariable Integer id) {
        ticketTypeService.deleteTicketTypeById(id);
    }
}
