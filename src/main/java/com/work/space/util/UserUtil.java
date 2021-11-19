package com.work.space.util;

import com.work.space.entity.Address;
import com.work.space.entity.Role;
import com.work.space.entity.User;
import com.work.space.to.AbstractUserTo;
import com.work.space.to.UserTo;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UserUtil {

    public static User toEntity(AbstractUserTo userTo) {
        String[] rolesFromTo = userTo.getRoles().split(",");
        Set<Role> roles = Arrays.stream(rolesFromTo).map(text -> Role.fromString(text)).collect(Collectors.toSet());
        User created = new User(
                Long.parseLong(userTo.getPhone()),
                userTo.getEmail(),
                userTo.getFirstName(),
                userTo.getSecondName(),
                userTo.getPatronymic(),
                roles);

        Address address = new Address(
                userTo.getAddress_id(),
                userTo.getX_coordinate(),
                userTo.getY_coordinate()
        );
        created.setAddress(address);
        return created;
    }

    public static List<UserTo> asTos(List<User> users) {
        return users.stream().map(UserUtil::asTo).collect(Collectors.toList());
    }

    public static UserTo asTo(User user) {
        return new UserTo(
                user.getId(),
                user.getPhone() + "",
                user.getEmail(),
                user.getFirstName(),
                user.getSecondName(),
                user.getPatronymic(),
                user.getAddress().getAddress_id(),
                user.getAddress().getX_coordinate(),
                user.getAddress().getY_coordinate(),

                user.getRoles()
                        .stream()
                        .map(Enum::toString)
                        .collect(Collectors.joining(",")));
    }

    public static User updateFromTo(User user, UserTo userTo) {

        Address address = user.getAddress();
        address.setAddress_id(userTo.getAddress_id());
        address.setX_coordinate(userTo.getX_coordinate());
        address.setY_coordinate(userTo.getY_coordinate());


        user.setFirstName(userTo.getFirstName());
        user.setSecondName(userTo.getSecondName());
        user.setPatronymic(userTo.getPatronymic());
        user.setEmail(userTo.getEmail());

        return user;
    }
}
