package com.work.space.service.employment;

import com.work.space.entity.Employment;
import com.work.space.repository.employment.CrudEmploymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EmploymentService {
    public final CrudEmploymentRepository crudEmploymentRepository;


    public EmploymentService(CrudEmploymentRepository crudEmploymentRepository) {
        this.crudEmploymentRepository = crudEmploymentRepository;
    }

    public Optional<Employment> get(int id) {
        return crudEmploymentRepository.get(id);
    }
    public Optional<Employment> getPlace(int employment_id) {
        return crudEmploymentRepository.getPlace(employment_id);
    }
    public List<Employment> getAll() {
        return crudEmploymentRepository.getAll();
    }

    public List<Employment> getAllPlaceFromThisFloor(Integer floor) {
        return crudEmploymentRepository.getAllPlaceFromThisFloor(floor);
    }
    public Employment save(Employment employment) {
        return crudEmploymentRepository.save(employment);
    }
    public void delete(Integer employment_id) {
        crudEmploymentRepository.delete(employment_id);
    }

}
