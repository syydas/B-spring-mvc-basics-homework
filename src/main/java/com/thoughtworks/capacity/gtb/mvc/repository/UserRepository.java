package com.thoughtworks.capacity.gtb.mvc.repository;

import com.thoughtworks.capacity.gtb.mvc.dataservice.DataService;
import com.thoughtworks.capacity.gtb.mvc.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {
    private final List<User> usersList = DataService.usersList;

    public void saveUser(User user) {
        usersList.add(user);
    }

    public List<User> getUsersList() {
        return usersList;
    }

    public User getUserByName(String username) {
        for (User user : usersList) {
            if (username.equals(user.getUsername())) {
                return user;
            }
        }
        return new User();
    }
}
