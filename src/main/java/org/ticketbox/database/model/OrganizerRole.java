package org.ticketbox.database.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Table(name="organizer_roles")
public class OrganizerRole extends BaseModel {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id" )
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "organizer_id")
    private Organizer organizer;
}
