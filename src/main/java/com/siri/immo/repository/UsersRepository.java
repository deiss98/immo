package com.siri.immo.repository;

import com.siri.immo.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByUsername(String userName);
    Boolean existsByUsername(String userName);
    Boolean existsByEmail(String email);


}
