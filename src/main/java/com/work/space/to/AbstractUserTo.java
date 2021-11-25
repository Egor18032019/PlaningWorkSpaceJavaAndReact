package com.work.space.to;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.work.space.entity.HasId;
import com.work.space.exception_handling.IncorectDataDuringRegistration;

import java.io.Serializable;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, isGetterVisibility = NONE, setterVisibility = NONE)
public abstract class AbstractUserTo implements HasId, Serializable {

    private Integer id;
    private final String phone;
    private final String email;
    private final String firstName;
    private final String secondName;
    private final String patronymic;

    private final Integer address_id;
    private final Integer employment_id;

    private final Integer company_id;


    private final String roles;

    public AbstractUserTo(String phone, String email, String firstName, String secondName,
                          String patronymic,
                          Integer  address_id,
                          Integer company_id,
                          Integer employment_id,
                          String roles) {
        this.phone = phone;
        this.email = email;
        this.firstName = firstName;
        this.secondName = secondName;
        this.patronymic = patronymic;
        this.address_id = address_id;
        this.company_id = company_id;
        this.employment_id = employment_id;


        this.roles = roles;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        String phone = this.phone;
        if (phone.length() != 11) {
            throw new IncorectDataDuringRegistration("Length " + phone + " is not 11");
        }

        char firstSymbol = '7';
        char secondSymbol = '9';

        if (phone.charAt(0) != firstSymbol) {
            throw new IncorectDataDuringRegistration("The first digit is not 7.");
        }
        if (phone.charAt(1) != secondSymbol) {
            throw new IncorectDataDuringRegistration("The second digit is not 9.");
        }

        return phone;
    }

    public String getEmail() {
        String email = this.email;
        String checkEmail = "@";
        if (!email.contains(checkEmail)) {
            throw new IncorectDataDuringRegistration("This no email.");
        }

        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public Integer getEmployment_id() {
        return employment_id;
    }

    public Integer getAddress_id() {
        return address_id;
    }

    public Integer getCompany_id() {
        return company_id;
    }

    public String getRoles() {
        return roles;
    }

    @Override
    public String toString() {
        return "AbstractUserTo{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", address_id=" + address_id +
                ", employment_id=" + employment_id +
                ", company_id=" + company_id +
                ", roles='" + roles + '\'' +
                '}';
    }
}
