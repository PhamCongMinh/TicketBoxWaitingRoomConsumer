package org.ticketbox.database.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "events")
@Builder
public class Event extends BaseModel {
    private String name;

    private String backgroundImageUrl;

    private Date startTime;

    private Date endTime;

    private String location;

    private String description;

    private String status;

    @ManyToOne()
    @JoinColumn(name = "organizer_id")
    @JsonIgnoreProperties("events")
    private Organizer organizer;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TicketType> ticketTypes;
}
