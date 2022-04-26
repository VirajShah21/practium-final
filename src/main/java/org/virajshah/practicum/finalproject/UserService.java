package org.virajshah.practicum.finalproject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void createUser(final User user) {
        System.out.println("Adding user: " + user.getUserId());
        System.out.println("User repository: " + userRepository);
        userRepository.save(user);
        System.out.println("Done saving user");
    }

    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        System.out.println("All users " + users.toString());
        System.out.println("User Repository: " + userRepository);
        userRepository.findAll().forEach(users::add);
        return users;
    }
}