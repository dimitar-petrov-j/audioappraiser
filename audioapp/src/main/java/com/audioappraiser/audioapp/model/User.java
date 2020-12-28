package com.audioappraiser.audioapp.model;

import javax.persistence.*;

import lombok.Setter;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String real_name;
    private String password;


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Role.class)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "userid"),
            inverseJoinColumns = @JoinColumn(name = "roleid"))
    private Set<Role> roles = new HashSet<>();


    public void setRoles(Set roles) {
        this.roles = roles;
    }

    public User(){}

    public User(String username, String password, String real_name){
        this.setUsername(username);
        this.setPassword(password);
        this.setReal_name(real_name);
    }
}
