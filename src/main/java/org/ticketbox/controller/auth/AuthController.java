package org.ticketbox.controller.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ticketbox.database.model.User;
import org.ticketbox.service.auth.AuthService;
import org.ticketbox.shared.dto.auth.LoginUserDto;
import org.ticketbox.shared.dto.auth.RegisterUserDto;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    public AuthService authService;

    @PostMapping("/register")
    public User register(@RequestBody RegisterUserDto dto) {
        return authService.register(dto);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginUserDto dto) {
        return authService.login(dto);
    }
}
