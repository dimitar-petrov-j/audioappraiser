package com.audioappraiser.audioapp.modelrepos.secondary;

import org.springframework.data.jpa.repository.JpaRepository;
import com.audioappraiser.audioapp.model.secondary.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
