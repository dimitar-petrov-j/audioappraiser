package com.audioappraiser.audioapp.security.service;

import com.audioappraiser.audioapp.model.Role;
import com.audioappraiser.audioapp.model.User;
import com.audioappraiser.audioapp.model.ERole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Setter;
import lombok.Getter;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class UserDetailsImpl implements UserDetails{
    private static final long serialVersionUID = 1L;

    private Long id;

    private String username;

    private String real_name;

    private Boolean is_private;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> roles;


    public UserDetailsImpl(Long id, String username, String real_name, String password,
                           Collection<? extends GrantedAuthority> roles) {
        this.id = id;
        this.username = username;
        this.real_name = real_name;
        this.password = password;
        this.roles = roles;
    }

    public static UserDetailsImpl build(User user) {

        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getRole().name()))
                .collect(Collectors.toList());

        return new UserDetailsImpl(
                user.getId(),
                user.getUsername(),
                user.getReal_name(),
                user.getPassword(),
                authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {return roles;}

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
