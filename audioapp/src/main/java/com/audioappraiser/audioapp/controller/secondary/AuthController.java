package com.audioappraiser.audioapp.controller.secondary;

import com.audioappraiser.audioapp.creationreqs.UserCreationRequest;
import com.audioappraiser.audioapp.model.secondary.User;
import com.audioappraiser.audioapp.modelrepos.secondary.RoleRepository;
import com.audioappraiser.audioapp.modelrepos.secondary.UserRepository;
import com.audioappraiser.audioapp.service.AudioappService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;


@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AudioappService audioappService;

//    @Autowired
//    @Qualifier("datasource-secondary")
//    private final DataSource secondaryDataSource;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @GetMapping("/signin")
    public ResponseEntity<User> signInUser(@PathVariable String username, @PathVariable String password) {
        return ResponseEntity.ok(audioappService.readUser(username, password));
    }

    @GetMapping("/users")
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
