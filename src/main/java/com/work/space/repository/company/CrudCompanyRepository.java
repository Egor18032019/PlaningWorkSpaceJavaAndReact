package com.work.space.repository.company;


import com.work.space.entity.Company;

public interface CrudCompanyRepository {

    Company get(int id);

    Company getByName(String name);

    Company save(Company equipment);

    void delete(int id);
}