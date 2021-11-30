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

    public Employment( ) {

    }

    public Employment(Integer employment_id) {
        this.employment_id = employment_id;
    }

    public Employment(Integer id, Integer employment_id, Integer x_coordinate, Integer y_coordinate) {
        super(id);

        this.employment_id = employment_id;
        this.x_coordinate = x_coordinate;
        this.y_coordinate = y_coordinate;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }



    public Integer getEmployment_id() {
        return employment_id;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public Integer getX_coordinate() {
        return x_coordinate;
    }

    public Integer getY_coordinate() {
        return y_coordinate;
    }
}
