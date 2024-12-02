package org.ticketbox.controller.organizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.ticketbox.database.model.Organizer;
import org.ticketbox.database.model.TicketType;
import org.ticketbox.service.organizer.OrganizerService;
import org.ticketbox.service.ticket_type.TicketTypeService;
import org.ticketbox.shared.base.BaseResponse;

import java.util.List;

@RestController()
@RequestMapping("/organizers")
public class OrganizerController {
    @Autowired
    private OrganizerService organizerService;

    @PostMapping
    public BaseResponse<Organizer> createTicketType(@RequestBody Organizer organizer) {
        return new BaseResponse<Organizer>(organizerService.createOrganizer(organizer));
    }

    @GetMapping("/{id}")
    public BaseResponse<Organizer> getOrganizerById(@PathVariable Integer id) {
        return new BaseResponse<Organizer>(organizerService.getOrganizerById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteTicketTypeById(@PathVariable Integer id) {
        organizerService.deleteOrganizerById(id);
    }
}
