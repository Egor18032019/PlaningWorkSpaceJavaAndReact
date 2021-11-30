package com.work.space.repository.equipment;

import com.work.space.entity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentTypeRepository extends JpaRepository<Equipment, Integer> {

    Equipment findByName(String name);
}

