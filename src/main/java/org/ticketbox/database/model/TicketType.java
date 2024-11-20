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
public class TicketType extends BaseModel {
    private String name;

    private String price;

    private String description;

    private String amount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="event_id")
    private Event event;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "ticketType")
    private List<Ticket> tickets;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "ticketType")
    private List<HeldTicket> heldTickets;
}
