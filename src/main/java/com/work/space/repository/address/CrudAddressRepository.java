package com.work.space.repository.address;


import com.work.space.entity.Address;

public interface CrudAddressRepository {

    Address get(int id);

    Address getByName(String name);

    Address save(Address equipment);

    void delete(int id);
}