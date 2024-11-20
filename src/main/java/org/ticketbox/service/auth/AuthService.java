package org.ticketbox.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.ticketbox.database.model.User;
import org.ticketbox.database.repository.UserRepository;
import org.ticketbox.shared.dto.auth.LoginUserDto;
import org.ticketbox.shared.dto.auth.RegisterUserDto;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    public User register(RegisterUserDto dto) {
        System.out.println(dto);
        User user =  User.builder()
                .email(dto.getEmail())
                .password(passwordEncoder.encode(dto.getPassword()))
                .userName(dto.getUsername())
                .role(dto.getRole())
                .build();

        return userRepository.save(user);
    }

    public String login(LoginUserDto dto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.getEmail(),
                        dto.getPassword()
                )
        );
        User user = userRepository.findByEmail(dto.getEmail()).orElseThrow();

        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(user);
        } else {
            throw new UsernameNotFoundException("Invalid user request!");
        }
    }
}
