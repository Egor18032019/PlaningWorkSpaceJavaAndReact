package com.work.space.entity;


import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "equipment_list")
public class EquipmentList extends AbstractBaseEntity {

    @Column(name = "invnumber")
    private String invnumber;
    @Column(name = "serialnumber")
    private String serialnumber;


    @Column(name = "user_id")
    private Integer user_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "equipment_id")
    private Equipment equipment_id;

    public EquipmentList() {
    }

    public EquipmentList(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }


    public Integer getUser() {
        return user_id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        EquipmentList that = (EquipmentList) o;
        return Objects.equals(invnumber, that.invnumber) &&
                Objects.equals(serialnumber, that.serialnumber) &&
                Objects.equals(user_id, that.user_id) &&
                Objects.equals(equipment_id, that.equipment_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), invnumber, serialnumber, user_id, equipment_id);
    }
}
