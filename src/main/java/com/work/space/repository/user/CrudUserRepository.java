package com.work.space.repository.user;

import com.work.space.entity.User;

import java.util.List;

public interface CrudUserRepository {

    // null if not found, when updated
    User save(User user);

    // false if not found
    boolean delete(Long phone);

    // null if not found
    User getByPhone(Long phone);

    List<User> getAll();
}
