package com.backend134.oberlo.repositories;

import com.backend134.oberlo.entities.Cars;
import com.backend134.oberlo.entities.Models;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<Models,Long> {
}
