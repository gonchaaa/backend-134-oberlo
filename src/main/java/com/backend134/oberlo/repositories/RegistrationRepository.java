package com.backend134.oberlo.repositories;

import com.backend134.oberlo.entities.Registration;
import com.backend134.oberlo.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegistrationRepository extends JpaRepository<Registration,Long> {
    Optional<Registration> findByEmail(String email);
}
