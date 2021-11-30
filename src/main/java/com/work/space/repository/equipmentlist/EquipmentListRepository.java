package com.work.space.repository.equipmentlist;

import com.work.space.entity.EquipmentList;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EquipmentListRepository extends JpaRepository<EquipmentList, Integer> {
    @Query("SELECT c FROM EquipmentList c WHERE c.user_id=:userId ORDER BY c.user_id DESC")
    List<EquipmentList> getAll(@Param("userId") int userId) throws DataAccessResourceFailureException;

    @Modifying
    @Transactional
    @Query("DELETE FROM EquipmentList c WHERE c.id=:id AND c.id=:userId")
    int delete(@Param("id") int id, @Param("userId") int userId);
}
