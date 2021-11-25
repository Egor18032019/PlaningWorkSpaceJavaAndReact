package com.work.space.repository.address;

import com.work.space.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address,Integer> {
    @Query("SELECT u FROM Address u WHERE u.id =:id")
    Optional<Address> needAdres(@Param("id") Integer id);
}
