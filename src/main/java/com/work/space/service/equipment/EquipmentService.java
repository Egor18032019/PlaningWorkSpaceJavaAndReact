package com.work.space.service.equipment;

import com.work.space.entity.EquipmentList;
import com.work.space.repository.equipmentlist.CrudEquipmentListRepository;
 import org.springframework.stereotype.Service;

import java.util.List;


//TODO сделалть что бы в одном сервисе выдавала данные из EquipmentList и
//
// выдать список что типа
// {["ноут",1,2] ,["ПК", 222,2233] }

@Service
public class EquipmentService {
    public final CrudEquipmentListRepository crudEquipmentListRepository;

    public EquipmentService(CrudEquipmentListRepository crudEquipmentListRepository) {
        this.crudEquipmentListRepository = crudEquipmentListRepository;
    }


    public EquipmentList save(EquipmentList counter, int userId) {
        return crudEquipmentListRepository.save(counter, userId);
    }

    public EquipmentList get(int id, int userId) {
        return crudEquipmentListRepository.get(id, userId);
    }

    public void delete(int id, int userId) {
        crudEquipmentListRepository.delete(id, userId);
    }

    public List<EquipmentList> getAll(int userId) {
        System.out.println("EquipmentList getAll");
        return crudEquipmentListRepository.getAll(userId);
    }
}
