package org.ticketbox.controller.ticket_type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.ticketbox.database.model.TicketType;
import org.ticketbox.service.ticket_type.TicketTypeService;
import org.ticketbox.shared.base.BaseResponse;
import org.ticketbox.shared.dto.ticket_type.CreateTicketTypeDto;

import java.util.List;
import java.util.Optional;

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
    public BaseResponse<TicketType> createTicketType(@RequestBody CreateTicketTypeDto ticketTypeDto) {
        return new BaseResponse<TicketType>(ticketTypeService.createTicketType(ticketTypeDto));
    }

    @GetMapping("/{id}")
    public BaseResponse<Optional<TicketType>> getTicketTypesById(@PathVariable Integer id) {
        return new BaseResponse<Optional<TicketType>>(ticketTypeService.getTicketTypeById(id));
    }

    @PutMapping("/{id}")
    public BaseResponse<TicketType> editTicketType(@PathVariable Integer id, @RequestBody CreateTicketTypeDto ticketTypeDto) {
        return new BaseResponse<TicketType>(ticketTypeService.editTicketType(id, ticketTypeDto));
    }

    @DeleteMapping("/{id}")
    public void deleteTicketTypeById(@PathVariable Integer id) {
        ticketTypeService.deleteTicketTypeById(id);
    }
}
