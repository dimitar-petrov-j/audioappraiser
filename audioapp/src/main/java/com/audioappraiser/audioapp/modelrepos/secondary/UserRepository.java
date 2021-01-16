package com.audioappraiser.audioapp.modelrepos.secondary;

import org.springframework.data.jpa.repository.JpaRepository;
import com.audioappraiser.audioapp.model.secondary.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Optional<User> findByUsernameAndPassword(String username, String password);
}
