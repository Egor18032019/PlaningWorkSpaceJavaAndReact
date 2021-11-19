package com.work.space.repository.company;


import com.work.space.entity.Company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public interface CompanyRepository extends JpaRepository<Company, Integer> {

    Optional<Company> findById(Integer id);
}
