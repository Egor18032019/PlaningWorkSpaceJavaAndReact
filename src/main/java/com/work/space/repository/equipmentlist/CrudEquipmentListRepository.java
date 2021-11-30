package com.work.space.repository.equipmentlist;

import com.work.space.entity.EquipmentList;

import java.util.List;

public interface CrudEquipmentListRepository {

    EquipmentList save(EquipmentList equipmentList, int userId);

    boolean delete(int id, int userId);

    EquipmentList get(int id, int userId);

    List<EquipmentList> getAll(int userId);
}
