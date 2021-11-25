package com.work.space.repository.employment;

import com.work.space.entity.Employment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmploymentRepository extends JpaRepository<Employment,Integer> {
    Optional<Employment> findById(Integer id);
}
