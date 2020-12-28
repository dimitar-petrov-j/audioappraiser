package com.audioappraiser.audioapp.modelrepos;

import com.audioappraiser.audioapp.model.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import com.audioappraiser.audioapp.model.Role;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
