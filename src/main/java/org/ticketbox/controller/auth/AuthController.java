//package org.ticketbox.controller.auth;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.ticketbox.database.model.User;
//import org.ticketbox.service.auth.AuthService;
//import org.ticketbox.shared.base.BaseResponse;
//import org.ticketbox.shared.dto.auth.LoginUserDto;
//import org.ticketbox.shared.dto.auth.RegisterUserDto;
//
//@RestController
//@RequestMapping("/auth")
//public class AuthController {
//    @Autowired
//    public AuthService authService;
//
//    @PostMapping("/register")
//    public BaseResponse<User> register(@RequestBody RegisterUserDto dto) {
//        return new BaseResponse<User>(authService.register(dto));
//    }
//
//    @PostMapping("/login")
//    public BaseResponse<String> login(@RequestBody LoginUserDto dto) {
//        return new BaseResponse<String>(authService.login(dto));
//    }
//}
