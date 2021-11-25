package com.work.space.entity;

import javax.persistence.*;

@Entity
@Table(name = "companies")
public class Company extends AbstractBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;


    @Column(name = "name")
    private String name;



    public Company() {}

    public Company( Integer id1) {

        this.id = id1;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '}';
    }

    @Override
    public Integer getId() {
        return id;
    }
}
