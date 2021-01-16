package com.audioappraiser.audioapp.creationreqs;

import com.audioappraiser.audioapp.model.secondary.Role;

import java.util.Set;

public class UserCreationRequest {
    private String username;
    private String real_name;
    private String password;
    private Set<Role> roles;
}
