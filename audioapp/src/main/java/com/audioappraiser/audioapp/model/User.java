package com.audioappraiser.audioapp.model;

import javax.persistence.*;

import lombok.Setter;
import lombok.Getter;

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
    public Set roles;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "roles",
            joinColumns = @JoinColumn(name = "userid"),
            inverseJoinColumns = @JoinColumn(name = "id"))
    public Set<Role> getRoles() {
        return roles;
    }

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
