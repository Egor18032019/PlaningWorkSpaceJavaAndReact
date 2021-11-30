package com.work.space.repository.equipmentlist;

import com.work.space.entity.EquipmentList;
import com.work.space.exception_handling.TimeOutSQLException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DataJpaEquipmentListRepository implements CrudEquipmentListRepository {
    public final EquipmentListRepository equipmentListRepository;

    public DataJpaEquipmentListRepository(EquipmentListRepository equipmentListRepository) {
        this.equipmentListRepository = equipmentListRepository;
    }

    @Override
    public EquipmentList save(EquipmentList equipmentList, int userId) {
        equipmentList = equipmentListRepository.save(equipmentList);
        return equipmentList;
    }


    @Override
    public boolean delete(int id, int userId) {
        return equipmentListRepository.delete(id, userId) == 0;
    }

    @Override
    public EquipmentList get(int id, int userId) {
        return  equipmentListRepository.findById(id).filter(equipmentList -> equipmentList.getUser() == userId)
                .orElse(null);
    }

    @Override
    public List<EquipmentList> getAll(int userId) {
        System.out.println("DataJpaEquipmentListRepository getall " + userId);
        List <EquipmentList> equipmentList;
        try {
            equipmentList = equipmentListRepository.getAll(userId);
        } catch (DataAccessResourceFailureException e) {
            throw new TimeOutSQLException("getAll not work or Time the end or BD not work.");
        }

        return equipmentList;
    }
}
