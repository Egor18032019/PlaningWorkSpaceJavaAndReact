package com.work.space.entity;


import javax.persistence.*;

@Entity
@Table(name = "addresses")
public class Address  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "address")
    private String address;

    public Address(String address) {
        this.address = address;
    }


    public Address() {

    }

    public Integer getId() {
        System.out.println("getId " + id);
        return id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

}
