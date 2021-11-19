package com.work.space.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "addresses")
public class Address extends AbstractBaseEntity {

    @Column(name = "address_id")
    private String address_id;

    @Column(name = "x_coordinate")
    private String x_coordinate;

    @Column(name = "y_coordinate")
    private String y_coordinate;



    public Address() {}
    public Address(Integer id, String address_id, String x_coordinate, String y_coordinate) {
        super(id);
        this.address_id = address_id;
        this.x_coordinate = x_coordinate;
        this.y_coordinate = y_coordinate;

    }
    public Address( String address_id, String x_coordinate, String y_coordinate) {
        this.address_id = address_id;
        this.x_coordinate = x_coordinate;
        this.y_coordinate = y_coordinate;
    }
    public void setAddress_id(String address_id) {
        this.address_id = address_id;
    }

    public void setX_coordinate(String x_coordinate) {
        this.x_coordinate = x_coordinate;
    }

    public void setY_coordinate(String y_coordinate) {
        this.y_coordinate = y_coordinate;
    }




    public String getAddress_id() {
        return address_id;
    }

    public String getX_coordinate() {
        return x_coordinate;
    }

    public String getY_coordinate() {
        return y_coordinate;
    }
}
