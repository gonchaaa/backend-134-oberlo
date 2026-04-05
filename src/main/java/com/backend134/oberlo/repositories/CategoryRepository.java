package com.backend134.oberlo.repositories;

import com.backend134.oberlo.entities.Cars;
import com.backend134.oberlo.entities.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Categories,Long> {
}
