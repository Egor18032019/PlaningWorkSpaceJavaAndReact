package com.work.space.repository.user;

import com.work.space.entity.User;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DataJpaUserRepository implements CrudUserRepository {
    private final UserRepository userRepository;

    public DataJpaUserRepository(

            UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public boolean delete(Long phone) {
        return userRepository.delete(phone) != 0;
    }

    @Override
    public User getByPhone(Long phone) {

        System.out.println("DataJpaUserRepository getByPhone " + phone);

        return userRepository.getByPhone(phone).orElse(null);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
