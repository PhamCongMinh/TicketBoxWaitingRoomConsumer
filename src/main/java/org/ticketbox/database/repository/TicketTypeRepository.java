package org.ticketbox.database.repository;

import org.ticketbox.database.model.TicketType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketTypeRepository extends JpaRepository<TicketType, Integer> {
    List<TicketType> findByEventId(long eventId);

    TicketType getTicketTypeById(long ticketTypeId);
}
