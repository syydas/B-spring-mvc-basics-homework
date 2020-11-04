package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.exception.UserExistsException;
import com.thoughtworks.capacity.gtb.mvc.model.User;
import com.thoughtworks.capacity.gtb.mvc.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register(User user) {
        if (!isUserExist(user.getUsername())) {
            userRepository.saveUser(user);
        } else {
            throw new UserExistsException("User exists!");
        }
    }

    public boolean isUserExist(String username) {
        return userRepository.getUsersList().stream()
                .anyMatch(user -> username.equals(user.getUsername()));
    }
    public User logIn(String userName, String password) {
        return userRepository.getUserByName(userName);
    }
}
