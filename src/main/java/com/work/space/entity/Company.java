package com.work.space.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "companies")
public class Company extends AbstractBaseEntity {

    @Column(name = "name")
    private String name;



    public Company() {}

    public Company(Integer id, String name, String address, Long phone) {
        super(id);
        this.name = name;

    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", address='" +
                '}';
    }
}
