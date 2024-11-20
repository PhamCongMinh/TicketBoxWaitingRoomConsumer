package org.ticketbox.database.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.ticketbox.database.model.BaseModel;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseModel implements UserDetails {
    private String userName;

    private String email;

    private String password;

    private Date dateOfBirth;

    private String role;

    private String status;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<OrganizerRole> organizerRoles;

    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER)
    private List<Ticket> tickets;

    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER)
    private List<HeldTicket> heldTickets;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role != null ? List.of(new SimpleGrantedAuthority(role)) : Collections.emptyList();
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getPassword() {
        return password;
    }
}
