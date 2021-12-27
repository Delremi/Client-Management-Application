package com.delremi.srini.service;

import com.delremi.srini.exception.EntityNotFoundException;
import com.delremi.srini.model.User;
import com.delremi.srini.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User saveUser(String username, String password) {
        return userRepository.save(new User(null, username, passwordEncoder.encode(password)));
    }

    public User getUser(String username) throws EntityNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new EntityNotFoundException(User.class, username);
        }
        return user;
    }

    public User getUser(int id) throws EntityNotFoundException {
        User user = userRepository.findById(id);
        if (user == null) {
            throw new EntityNotFoundException(User.class, id);
        }
        return user;
    }
}
