package com.backend134.oberlo.repositories;

import com.backend134.oberlo.entities.Cars;
import com.backend134.oberlo.entities.Models;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CarRepository extends JpaRepository<Cars,Long> {
   Optional<Cars> findById(Long id);
   Optional<Models> findByModelId(Long modelId);
}
//optional -- datan;n ispresent in the repository interface to handle cases where a car with the given ID might not exist.