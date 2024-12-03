package org.ticketbox.shared.dto.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEventDto {
    private String name;

    private String backgroundImageUrl;

    private Date startTime;

    private Date endTime;

    private String location;

    private String description;

    private String status;

    private Integer organizerId;
}
