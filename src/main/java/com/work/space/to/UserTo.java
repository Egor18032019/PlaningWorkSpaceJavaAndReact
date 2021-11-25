package com.work.space.to;

import java.beans.ConstructorProperties;

public class UserTo extends AbstractUserTo {

    @ConstructorProperties({"id", "phone", "email", "firstName", "secondName", "patronymic",
            "address_id", "employment_id", "company_id",
            "roles"})
    public UserTo(Integer id, String phone, String email, String firstName, String secondName, String patronymic,
                  Integer address_id,
                  Integer company_id,
                  Integer employment_id,
                  String roles) {

        super(phone, email, firstName, secondName, patronymic,
                address_id,
                company_id,
                employment_id,
                roles);
        this.setId(id);
    }

}
