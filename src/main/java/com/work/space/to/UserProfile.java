package com.work.space.to;

import com.work.space.entity.Address;
import com.work.space.entity.Company;
import com.work.space.entity.Employment;
import com.work.space.entity.EquipmentList;

import java.beans.ConstructorProperties;
import java.util.List;

public class UserProfile {

    public final String phone;
    public final String email;
    public final String firstName;
    public final String secondName;
    public final String patronymic;

    public final String address;
    public final String company;
    public final Employment employment;
    public final List<EquipmentList> equipmentList;

    @ConstructorProperties({"id", "phone", "email", "firstName", "secondName", "patronymic",
            "address",
            "company",
            "employment,equipmentList"})
    public UserProfile(String phone, String email, String firstName, String secondName, String patronymic,
                       Address address, Company company, Employment employment, List<EquipmentList> equipmentList) {


        this.phone = phone;
        this.email = email;
        this.firstName = firstName;
        this.secondName = secondName;
        this.patronymic = patronymic;
        this.address = address.getAddress();
        this.company = company.getName();
        this.employment = employment;
        this.equipmentList = equipmentList;

    }


}
