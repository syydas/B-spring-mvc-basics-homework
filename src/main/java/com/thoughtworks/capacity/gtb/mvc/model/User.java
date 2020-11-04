package com.thoughtworks.capacity.gtb.mvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String userName;
    private String password;
    private String email;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
