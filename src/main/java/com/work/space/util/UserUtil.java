package com.work.space.util;

import com.work.space.entity.*;
import com.work.space.exception_handling.IncorectDataDuringRegistration;
import com.work.space.repository.address.AddressRepository;
import com.work.space.repository.company.CompanyRepository;
import com.work.space.repository.employment.EmploymentRepository;
import com.work.space.to.AbstractUserTo;
import com.work.space.to.UserTo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class UserUtil {

    @Autowired
    private static EmploymentRepository employmentRepository;
    @Autowired
    private static CompanyRepository companyRepository;
    @Autowired
    private static AddressRepository addressRepository;


    public static User toEntity(AbstractUserTo userTo) {
        String[] rolesFromTo = userTo.getRoles().split(",");
        System.out.println("rolesFromTo" + Arrays.toString(rolesFromTo));
        Set<Role> roles = Arrays.stream(rolesFromTo).map(text -> Role.fromString(text)).collect(Collectors.toSet());
        User created = new User(
                Long.parseLong(userTo.getPhone()),
                userTo.getEmail(),
                userTo.getFirstName(),
                userTo.getSecondName(),
                userTo.getPatronymic(),
                userTo.getAddress_id(),
                userTo.getEmployment_id(),
                userTo.getCompany_id(),
                roles);
        System.out.println("Началась выборка по ид");
        System.out.println(userTo.getAddress_id());
        if (addressRepository.needAdres(userTo.getAddress_id()).isPresent()) {
            System.out.println("убедились что адрес есть");
          Address address =addressRepository.needAdres(userTo.getAddress_id()).get();
            created.setAddress(address);
        }else {
            throw new IncorectDataDuringRegistration("Not find address for id = " + userTo.getAddress_id());
        }
        System.out.println(userTo.getCompany_id());
        if (companyRepository.findById(userTo.getCompany_id()).isPresent()) {
            Company company = companyRepository.findById(userTo.getCompany_id()).get();
            created.setCompany(company);
        }else {
            throw new IncorectDataDuringRegistration("Not find company for id = " + userTo.getAddress_id());
        }
        System.out.println(userTo.getEmployment_id());
        if (employmentRepository.findById(userTo.getEmployment_id()).isPresent()) {
            Employment employment = employmentRepository.findById(userTo.getEmployment_id()).get();
            created.setEmployment(employment);
        }else {
            throw new IncorectDataDuringRegistration("Not find employment for id = " + userTo.getAddress_id());
        }

        return created;
    }

    public static List<UserTo> asTos(List<User> users) {
        return users.stream().map(UserUtil::asTo).collect(Collectors.toList());
    }

    public static UserTo asTo(User user) {
        System.out.println(" asTo " + user.toString());
        String role = user.getRoles()
                .stream()
                .map(Enum::toString)
                .collect(Collectors.joining(","));
        System.out.println(role);
        return new UserTo(
                user.getId(),
                user.getPhone() + "",
                user.getEmail(),
                user.getFirstName(),
                user.getSecondName(),
                user.getPatronymic(),

                user.getAddress_id(),
                user.getCompany_id(),
                user.getEmployment_id(),
                role
        );

    }

    public static User updateFromTo(User user, UserTo userTo) {

        Employment employment = user.getEmployment();
        employment.setId(userTo.getEmployment_id());
        Address address = user.getAddress();
        address.setId(userTo.getAddress_id());

        user.setFirstName(userTo.getFirstName());
        user.setSecondName(userTo.getSecondName());
        user.setPatronymic(userTo.getPatronymic());
        user.setEmail(userTo.getEmail());

        return user;
    }
}
