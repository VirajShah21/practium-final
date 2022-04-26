package org.virajshah.practicum.finalproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void createUser(final User customer) {
        userRepository.save(customer);
    }
}