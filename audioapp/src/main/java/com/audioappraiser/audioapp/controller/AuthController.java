package com.audioappraiser.audioapp.controller;

import com.audioappraiser.audioapp.creationreqs.UserCreationRequest;
import com.audioappraiser.audioapp.model.User;
import com.audioappraiser.audioapp.model.Role;
import com.audioappraiser.audioapp.model.ERole;
import com.audioappraiser.audioapp.modelrepos.RoleRepository;
import com.audioappraiser.audioapp.modelrepos.UserRepository;
import com.audioappraiser.audioapp.service.AudioappService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;


@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AudioappService audioappService;

    @Autowired
    @Qualifier("secondaryDataSource")
    private final DataSource secondaryDataSource;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @GetMapping("/signin")
    public ResponseEntity<User> signInUser(@PathVariable String username, @PathVariable String password) {
        return ResponseEntity.ok(audioappService.readUser(username, password));
    }

    @GetMapping("/getusers")
    public ResponseEntity readUsers(@PathVariable Long userId){
        if(userId == null)
        {
            return ResponseEntity.ok(audioappService.readAllUsers());
        }
        return ResponseEntity.ok(audioappService.readUserById(userId));
    }

    @PostMapping("/signup")
    public ResponseEntity<User> registerUser(@RequestBody UserCreationRequest signUpRequest) {
        return ResponseEntity.ok(audioappService.createUser(signUpRequest));
    }
}
