package com.work.space.repository.employment;


import com.work.space.entity.Employment;

import java.util.List;
import java.util.Optional;

public interface CrudEmploymentRepository {

    Optional<Employment> get(int id);

    Optional<Employment> getPlace(int employment_id);

    List<Employment> getAll();


    List<Employment> getAllPlaceFromThisFloor(int floor);

    Employment save(Employment employment);

    void delete(int employment_id);
}