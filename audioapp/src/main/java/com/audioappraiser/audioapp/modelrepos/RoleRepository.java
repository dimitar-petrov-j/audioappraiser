package com.audioappraiser.audioapp.modelrepos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.audioappraiser.audioapp.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
