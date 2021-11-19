package com.work.space.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "addresses")
public class Address extends AbstractBaseEntity {

    @Column(name = "address_id")
    private Integer address_id;

    @Column(name = "x_coordinate")
    private Integer x_coordinate;

    @Column(name = "y_coordinate")
    private Integer y_coordinate;



    public Address() {}
    public Address(Integer id, Integer address_id, Integer x_coordinate, Integer y_coordinate) {
        super(id);
        this.address_id = address_id;
        this.x_coordinate = x_coordinate;
        this.y_coordinate = y_coordinate;

    }
    public Address( Integer address_id, Integer x_coordinate, Integer y_coordinate) {
        this.address_id = address_id;
        this.x_coordinate = x_coordinate;
        this.y_coordinate = y_coordinate;
    }



    public void setAddress_id(Integer address_id) {
        this.address_id = address_id;
    }

    public void setX_coordinate(Integer x_coordinate) {
        this.x_coordinate = x_coordinate;
    }

    public void setY_coordinate(Integer y_coordinate) {
        this.y_coordinate = y_coordinate;
    }




    public Integer getAddress_id() {
        return address_id;
    }

    public Integer getX_coordinate() {
        return x_coordinate;
    }

    public Integer getY_coordinate() {
        return y_coordinate;
    }
}
