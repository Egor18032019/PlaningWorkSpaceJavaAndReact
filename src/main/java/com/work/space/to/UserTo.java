package com.work.space.to;

import java.beans.ConstructorProperties;

public class UserTo extends AbstractUserTo {

    @ConstructorProperties({"id", "phone", "email", "firstName", "secondName", "patronymic",
            "address_id", "x_coordinate", "y_coordinate",
            "building", "apartment",
            "roles"})
    public UserTo(Integer id, String phone, String email, String firstName, String secondName, String patronymic,
                  String address_id, String x_coordinate, String y_coordinate,
                  String roles) {

        super(phone, email, firstName, secondName, patronymic,
                address_id, x_coordinate, y_coordinate,
                roles);
        this.setId(id);
    }

}
