package com.audioappraiser.audioapp.controller;

import com.audioappraiser.audioapp.model.User;
import com.audioappraiser.audioapp.model.Role;
import com.audioappraiser.audioapp.model.ERole;
import com.audioappraiser.audioapp.modelrepos.RoleRepository;
import com.audioappraiser.audioapp.modelrepos.UserRepository;
import com.audioappraiser.audioapp.payload.request.LoginRequest;
import com.audioappraiser.audioapp.payload.request.SignupRequest;
import com.audioappraiser.audioapp.payload.response.JwtResponse;
import com.audioappraiser.audioapp.payload.response.MessageResponse;
import com.audioappraiser.audioapp.security.jwt.JwtUtils;
import com.audioappraiser.audioapp.security.service.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;


}
