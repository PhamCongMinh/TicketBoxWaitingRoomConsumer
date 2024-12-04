package org.ticketbox.shared.type;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WaitingRoomMessage {
    private Integer eventId;

    private Integer userId;
}
