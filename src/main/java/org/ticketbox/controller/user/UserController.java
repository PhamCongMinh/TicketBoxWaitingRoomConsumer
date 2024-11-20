package org.ticketbox.controller.user;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.ticketbox.database.model.User;
import org.ticketbox.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.ticketbox.shared.base.BaseResponse;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public BaseResponse<List<User>> getAll() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        User currentUser = (User) authentication.getPrincipal();
//        System.out.println(currentUser);
        return new BaseResponse<List<User>>(userService.findAll());
    }

    @GetMapping("/{id}")
    public BaseResponse<Optional<User>> findById(@PathVariable Integer id) {
        return new BaseResponse<Optional<User>>(userService.findById(id));
    }

    @PostMapping
    public BaseResponse<User> create(@RequestBody User user) {
        return new BaseResponse<User>(userService.save(user));
    }

    @PutMapping
    public BaseResponse<User> update(@RequestBody User user) {
        return new BaseResponse<User>(userService.save(user));
    }

    @DeleteMapping("/{id}")
    public BaseResponse<String> deleteById(@PathVariable Integer id) {
        userService.deleteById(id);
        return new BaseResponse<String>("Oke");
    }
}
