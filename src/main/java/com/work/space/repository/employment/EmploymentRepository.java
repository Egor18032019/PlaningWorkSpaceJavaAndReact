package com.work.space.repository.employment;

import com.work.space.entity.Employment;
import com.work.space.entity.Equipment;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
@Repository
public interface EmploymentRepository extends JpaRepository<Employment,Integer> {
    @Query("SELECT c FROM Employment c WHERE c.id=:id")
    Optional<Employment> findById(Integer id);

    @Query("SELECT c FROM Employment c WHERE c.employment_id=:employment_id")
    Optional<Employment> getPlace(@Param("employment_id") Integer employment_id);
    @Query("SELECT '*' FROM Employment ")
    List<Employment> getAll() throws DataAccessResourceFailureException;

    @Query("SELECT c FROM Employment c WHERE c.floor=:floor")
    List<Employment> getAllPlaceFromThisFloor(@Param("floor")Integer floor) throws DataAccessResourceFailureException;

    @Override
    Employment save (Employment employment);

    @Modifying
    @Transactional
    @Query("DELETE FROM Employment c WHERE c.id=:employment_id")
    int delete(@Param("employment_id") int employment_id);
}
