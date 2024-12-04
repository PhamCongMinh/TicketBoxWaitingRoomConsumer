package org.ticketbox.shared.dto.waiting_room;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JoinWaitingRoomDto {
    private Integer eventId;
    private Integer userId;
}
