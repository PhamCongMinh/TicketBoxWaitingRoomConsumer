package org.ticketbox.database.repository;

import org.ticketbox.database.model.OrganizerRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizerRoleRepository extends JpaRepository<OrganizerRole, Integer> {
}
