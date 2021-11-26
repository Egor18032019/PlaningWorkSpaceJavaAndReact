package com.work.space.repository.employment;

import com.work.space.entity.Employment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface EmploymentRepository extends JpaRepository<Employment,Integer> {
    Optional<Employment> findById(Integer id);
}
