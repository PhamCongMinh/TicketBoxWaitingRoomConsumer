package org.ticketbox.database.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "waiting_room_settings")
public class WaitingRoomSetting extends BaseModel {
    private long eventId;

    private boolean enableWaitingRoom;

    private Integer maxConcurrentProcessing;
}
