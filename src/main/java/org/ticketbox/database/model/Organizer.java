package org.ticketbox.database.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name="organizers")
public class Organizer extends BaseModel {
    private String name;

    private String description;

    private String backgroundImageUrl;

    @OneToMany(mappedBy = "organizer", fetch = FetchType.EAGER)
    private List<Event> events;
}
