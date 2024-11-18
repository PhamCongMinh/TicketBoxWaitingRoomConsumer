package org.ticketbox.database.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String userName;

    private String email;

    private String password;

    private Date dateOfBirth;

    private String role;

    private String status;

    @OneToMany(mappedBy = "user")
    private List<OrganizerRole> organizerRoles;

    @OneToMany(mappedBy = "owner")
    private List<Ticket> tickets;

    @OneToMany(mappedBy = "owner")
    private List<HeldTicket> heldTickets;
}
