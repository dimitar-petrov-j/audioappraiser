package com.audioappraiser.audioapp.modelrepos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.audioappraiser.audioapp.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Optional<User> findByUsernameAndPassword(String username, String password);
}
