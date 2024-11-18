package org.ticketbox.database.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ticket_types")
public class TicketType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String price;

    private String description;

    private String amount;

    @ManyToOne
    @JoinColumn(name="event_id")
    private Event event;

    @OneToMany
    @JoinColumn(name = "ticketType")
    private List<Ticket> tickets;

    @OneToMany
    @JoinColumn(name = "ticketType")
    private List<HeldTicket> heldTickets;
}
