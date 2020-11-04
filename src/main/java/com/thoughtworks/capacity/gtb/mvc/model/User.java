package com.thoughtworks.capacity.gtb.mvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private int id;
    @NotNull(message = "Need user name")
    @Pattern(regexp = "\\w{3,10}$", message = "Invalid username")
    private String username;
    @NotNull(message = "Need password")
    @Pattern(regexp = "^.{5,12}$", message = "Invalid password")
    private String password;
    @Email(message = "Invalid email")
    private String email;
}
