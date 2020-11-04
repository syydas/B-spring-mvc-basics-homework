package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.exception.UserExistsException;
import com.thoughtworks.capacity.gtb.mvc.model.User;
import com.thoughtworks.capacity.gtb.mvc.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;
import java.util.regex.Pattern;

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

    public User logIn(String username, String password) {
        if (!username.matches("\\w{3,10}$")) {
            throw new UserExistsException("Invalid username");
        }
        if (!password.matches("^.{5,12}")) {
            throw new UserExistsException("Invalid password");
        }
        User user = userRepository.getUserByName(username);
        if (!user.getPassword().equals(password)) {
            throw new UserExistsException("Error username or password");
        }
        return user;
    }
}
