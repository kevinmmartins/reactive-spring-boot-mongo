package com.application.spring.controllers;

import com.application.spring.models.User;
import com.application.spring.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping(path = "/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public @ResponseBody
    Mono<User> createUser(@RequestBody User user) {
        return this.userService.createUser(user);
    }

    @GetMapping()
    public @ResponseBody
    Flux<User> findAllUsers() {
        return userService.findAllUsers();
    }
}
