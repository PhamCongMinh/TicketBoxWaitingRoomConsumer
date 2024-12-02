package org.ticketbox.service.organizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ticketbox.database.model.Organizer;
import org.ticketbox.database.repository.OrganizerRepository;

import java.util.List;

@Service
public class OrganizerService {
    @Autowired
    private OrganizerRepository organizerRepository;

    public Organizer createOrganizer(Organizer organizer) {
        return organizerRepository.save(organizer);
    }

    public Organizer getOrganizerById(Integer id) {
        return organizerRepository.getOrganizerById(id);
    }

    public void deleteOrganizerById(Integer id) {
        organizerRepository.deleteById(id);
    }
}
