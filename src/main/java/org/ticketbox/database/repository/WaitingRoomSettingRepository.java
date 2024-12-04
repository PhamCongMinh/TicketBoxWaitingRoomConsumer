package org.ticketbox.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.ticketbox.database.model.WaitingRoomSetting;

import java.util.Optional;

@Repository
public interface WaitingRoomSettingRepository extends JpaRepository<WaitingRoomSetting, Integer> {
    Optional<WaitingRoomSetting> findById(long id);
}
