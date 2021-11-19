package com.work.space.repository.equipment;

import com.work.space.entity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentRepository extends JpaRepository<Equipment, Integer> {

    Equipment findByName(String name);
}

