package com.work.space.util;

import com.work.space.entity.*;
import com.work.space.repository.address.AddressRepository;
import com.work.space.service.equipment.EquipmentService;
import com.work.space.to.AbstractUserTo;
import com.work.space.to.UserProfile;
import com.work.space.to.UserTo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UserUtil {

    public static User toEntity(AbstractUserTo userTo) {
        System.out.println(" toEntity ");
        String[] rolesFromTo = userTo.getRoles().split(",");
        Set<Role> roles = Arrays.stream(rolesFromTo).map(Role::fromString).collect(Collectors.toSet());

        return new User(
                Long.parseLong(userTo.getPhone()),
                userTo.getEmail(),
                userTo.getFirstName(),
                userTo.getSecondName(),
                userTo.getPatronymic(),
                userTo.getAddress_id(),
                userTo.getCompany_id(),
                userTo.getEmployment_id(),
                roles);
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

    public static UserProfile asToProfile(User user,List<EquipmentList> equipmentList ) {
        System.out.println(" asToProfile " + user.toString());

        return new UserProfile(
                user.getPhone() + "",
                user.getEmail(),
                user.getFirstName(),
                user.getSecondName(),
                user.getPatronymic(),
                user.getAddress(),
                user.getCompany(),
                user.getEmployment(),
                equipmentList
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
