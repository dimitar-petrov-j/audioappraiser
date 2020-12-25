package com.audioappraiser.audioapp.modelrepos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.audioappraiser.audioapp.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);
}
