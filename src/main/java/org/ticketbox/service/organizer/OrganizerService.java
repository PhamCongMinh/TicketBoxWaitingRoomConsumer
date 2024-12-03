package org.ticketbox.service.organizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ticketbox.database.model.Organizer;
import org.ticketbox.database.repository.OrganizerRepository;
import org.ticketbox.shared.constant.ErrorCodeConstant;
import org.ticketbox.shared.exception.custom.BadRequestException;

import java.util.Optional;

@Service
public class OrganizerService {
    @Autowired
    private OrganizerRepository organizerRepository;

    public Organizer createOrganizer(Organizer organizer) {
        return organizerRepository.save(organizer);
    }

    public Organizer getOrganizerById(Integer id) {
        return organizerRepository.getOrganizerById(id)
                .orElseThrow(() -> new BadRequestException(ErrorCodeConstant.ORGANIZER_NOT_EXIST));
    }

    public Organizer editOrganizer(Integer id, Organizer organizer) {
        Organizer isExist = organizerRepository.findById(id)
                .orElseThrow(() -> new BadRequestException(ErrorCodeConstant.ORGANIZER_NOT_EXIST));

        organizer.setId(isExist.getId());
        return organizerRepository.save(organizer);
    }

    public void deleteOrganizerById(Integer id) {
        organizerRepository.deleteById(id);
    }
}
