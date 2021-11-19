package com.work.space.repository.equipment;

import com.work.space.entity.Equipment;

public class DataJpaEquipmentRepository implements CrudEquipmnentRepository {

    public final EquipmentRepository serviceRepository;

    public DataJpaEquipmentRepository(EquipmentRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public Equipment get(int id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public Equipment getByName(String name) {
        return serviceRepository.findByName(name);
    }

    @Override
    public Equipment save(Equipment service) {
        return serviceRepository.save(service);
    }

    @Override
    public void delete(int id) {
        serviceRepository.deleteById(id);
    }
}