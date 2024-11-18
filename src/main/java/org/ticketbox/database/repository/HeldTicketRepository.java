package org.ticketbox.database.repository;

import org.ticketbox.database.model.HeldTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeldTicketRepository extends JpaRepository<HeldTicket,Integer> {
}
