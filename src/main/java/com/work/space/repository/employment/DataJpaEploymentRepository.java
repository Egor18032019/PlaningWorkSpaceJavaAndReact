package com.work.space.repository.employment;

import com.work.space.entity.Employment;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DataJpaEploymentRepository implements CrudEmploymentRepository {
    private final EmploymentRepository employmentRepository;

    public DataJpaEploymentRepository(EmploymentRepository employmentRepository) {
        this.employmentRepository = employmentRepository;
    }

    @Override
    public Optional<Employment> get(int id) {
        return employmentRepository.findById(id);
    }

    @Override
    public Optional<Employment> getPlace(int id) {
        return employmentRepository.getPlace(id);
    }

    @Override
    public List<Employment> getAll() {
        return employmentRepository.getAll();
    }


    @Override
    public List<Employment> getAllPlaceFromThisFloor(int floor) {
        return employmentRepository.getAllPlaceFromThisFloor(floor);
    }
    @Override
    public Employment save(Employment employment) {
        return employmentRepository.save(employment);
    }
    @Override
    public void delete(int employment_id) {
        employmentRepository.delete(employment_id);
    }
}
