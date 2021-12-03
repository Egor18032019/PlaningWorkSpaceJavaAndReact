package com.work.space.entity;


import javax.persistence.*;

@Entity
@Table(name = "employment")
public class Employment extends AbstractBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;


    @Column(name = "employment_id")
    private Integer employment_id;

    @Column(name = "x_coordinate")
    private Integer x_coordinate;

    @Column(name = "y_coordinate")
    private Integer y_coordinate;
    @Column(name = "floor")
    private Integer floor;

    public Employment() {

    }

    public Employment(Integer employment_id) {
        this.employment_id = employment_id;
    }



    public Employment(Integer id, Integer employment_id, Integer x_coordinate, Integer y_coordinate) {
        super(id);

        this.employment_id = employment_id;
        this.x_coordinate = x_coordinate;
        this.y_coordinate = y_coordinate;
        this.floor= floor;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public Integer getEmployment_id() {
        return employment_id;
    }

    public Integer getX_coordinate() {
        return x_coordinate;
    }

    public Integer getY_coordinate() {
        return y_coordinate;
    }

    public Integer getFloor() {
        return floor;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public void setEmployment_id(Integer employment_id) {
        this.employment_id = employment_id;
    }

    public void setX_coordinate(Integer x_coordinate) {
        this.x_coordinate = x_coordinate;
    }

    public void setY_coordinate(Integer y_coordinate) {
        this.y_coordinate = y_coordinate;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }
}
