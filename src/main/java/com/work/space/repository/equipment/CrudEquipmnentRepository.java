package com.work.space.repository.equipment;


import com.work.space.entity.Equipment;

public interface CrudEquipmnentRepository {

    Equipment get(int id);

    Equipment getByName(String name);

    Equipment save(Equipment equipment);

    void delete(int id);
}