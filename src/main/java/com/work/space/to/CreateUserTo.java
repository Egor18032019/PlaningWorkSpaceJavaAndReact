package com.work.space.to;

import com.work.space.entity.HasId;

import java.beans.ConstructorProperties;
import java.io.Serializable;

public class CreateUserTo extends AbstractUserTo implements HasId, Serializable {

    private final String otp;

    @ConstructorProperties({"id", "phone", "email", "firstName", "secondName",
            "patronymic", "address_id", "company_id", "roles"})
    public CreateUserTo(String phone, String email, String firstName, String secondName,
                        String patronymic, Integer address_id, Integer x_coordinate,
                        Integer y_coordinate,String roles,String otp) {

        super(phone, email, firstName, secondName, patronymic,
                address_id, x_coordinate, y_coordinate, roles);
        this.otp = otp;
    }

    public String getOtp() {
        return otp;
    }

}