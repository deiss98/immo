package com.siri.immo.repository;

import com.siri.immo.model.ERoles;
import com.siri.immo.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolesRepository extends JpaRepository<Roles, Long> {
    Optional<Roles> findByNomRoles(ERoles name);
}
