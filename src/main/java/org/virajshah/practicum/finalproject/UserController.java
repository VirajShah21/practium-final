package org.virajshah.practicum.finalproject;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
class UserController {
    List<User> users;

    public UserController() {
        this.users = new ArrayList<>();
    }

    @PostMapping("/users")
    User postUser() {
        User user = new User(UUID.randomUUID().toString(), new Date().getTime());
        this.users.add(user);
        return user;
    }

    @GetMapping("/users")
    List<User> getUsers() {
        return users;
    }
}