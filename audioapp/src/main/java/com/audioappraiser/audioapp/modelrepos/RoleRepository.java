package com.audioappraiser.audioapp.modelrepos;

import com.audioappraiser.audioapp.model.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import com.audioappraiser.audioapp.model.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
