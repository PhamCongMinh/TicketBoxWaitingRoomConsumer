package org.ticketbox.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.ticketbox.database.model.User;
import org.ticketbox.database.repository.UserRepository;

import java.util.Optional;


@Service
public class UserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(username); // Assuming 'email' is used as username
        return user.orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }
}
