package org.ticketbox.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.ticketbox.database.model.Organizer;

import java.util.Optional;

@Repository
public interface OrganizerRepository extends JpaRepository<Organizer, Integer> {
    Optional<Organizer> getOrganizerById(long id);
}
