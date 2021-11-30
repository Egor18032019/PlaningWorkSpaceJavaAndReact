package com.work.space.to;

import com.work.space.entity.HasId;

import java.beans.ConstructorProperties;
import java.io.Serializable;

public class CreateUserTo extends AbstractUserTo implements HasId, Serializable {

    private final String otp;

    @ConstructorProperties({"id", "phone", "email", "firstName", "secondName",
            "patronymic","address_id", "employment_id", "company_id", "roles"})
    public CreateUserTo(String phone, String email, String firstName, String secondName,
                        String patronymic,
                        Integer address_id, Integer company_id,
                         Integer employment_id,String roles,String otp) {

        super(phone, email, firstName, secondName, patronymic,
                address_id,company_id, employment_id,roles);
        this.otp = otp;
    }

//    {
//                "phone": "79999999999",
//                "email": "qwe@asd.re",
//                "firstName": "fname",
//                "secondName": "secondName",
//                "patronymic": "patronymic",
//                "address_id": 80000,
//                "company_id": 5000,
//                "roles": "User",
//                "x_coordinate": "22",
//                "y_coordinate": "22",
//                "otp": "59664"
//        }
    public String getOtp() {
        return otp;
    }

}