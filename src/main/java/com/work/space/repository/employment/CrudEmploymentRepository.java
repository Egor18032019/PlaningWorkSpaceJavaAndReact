package com.work.space.repository.employment;


import com.work.space.entity.Employment;

public interface CrudEmploymentRepository {

    Employment get(int id);

    Employment getByName(String name);

    Employment save(Employment equipment);

    void delete(int id);
}