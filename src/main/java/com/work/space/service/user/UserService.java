package com.work.space.service.user;


import com.work.space.entity.User;
import com.work.space.repository.company.CompanyRepository;
import com.work.space.repository.user.CrudUserRepository;
import com.work.space.repository.user.DataJpaUserRepository;
import com.work.space.repository.user.UserRepository;
import com.work.space.service.OtpService;
import com.work.space.to.AuthorizedUser;
import com.work.space.to.UserTo;
import com.work.space.util.UserUtil;
import com.work.space.util.ValidationUtil;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    public final CrudUserRepository userRepository;
    public final CompanyRepository companyRepository;
    public final OtpService otpService;

    public UserService(CrudUserRepository userRepository, CompanyRepository companyRepository, OtpService otpService) {
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
        this.otpService = otpService;
    }

    @Override
    public AuthorizedUser loadUserByUsername(String phone) throws UsernameNotFoundException {
        System.out.println(phone);
        User user = userRepository.getByPhone(Long.parseLong(phone));

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new AuthorizedUser(user);
    }

    public User getByPhone(long phone) {
        System.out.println("UserService getByPhone" + phone);
        return ValidationUtil.checkNotFoundWithPhone(userRepository.getByPhone(phone), phone);
    }

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public User create(User user) {
        ValidationUtil.checkPhone(userRepository.getByPhone(user.getPhone()) != null);
        user.setCompany(companyRepository.getById(50000));// fixme заглушка
        return userRepository.save(user);
    }

    public void update(UserTo userTo, int authUserId) {
        ValidationUtil.checkIdEquality(userTo, authUserId);

        long phoneFromTo = Long.parseLong(userTo.getPhone());

        User user = getByPhone(phoneFromTo);
        //User cannot change phone number! Only the administrator can..
        ValidationUtil.checkPhoneEquality(phoneFromTo, user.getPhone());

        userRepository.save(UserUtil.updateFromTo(user, userTo));
    }

    public void delete(Long phone) {
        ValidationUtil.checkNotFoundWithPhone(userRepository.delete(phone), phone);
    }
}
