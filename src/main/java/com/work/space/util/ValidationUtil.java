package com.work.space.util;


import com.work.space.entity.HasId;
import com.work.space.entity.User;
import com.work.space.exception_handling.NotFoundException;

public class ValidationUtil {



    public static void checkNotFoundWithPhone(boolean found, long phone)
    {
        checkNotFound(found, "id=" + phone);
    }


    public static User checkNotFoundWithPhone(User user, long phone) {
        checkNotFoundWithPhone(user != null, phone);
        return user;
    }



    public static void checkNotFound(boolean found, String msg) {
        if (!found) {
            throw new NotFoundException("Not found entity with " + msg);
        }
    }

    public static void checkIdEquality(HasId bean, int id) {
        if (bean.id() != id) {
            throw new NotFoundException(bean + " must be with id=" + id);
        }
    }

    public static void checkPhoneEquality(long updatePhone, long phone) {
        if (updatePhone != phone) {
            throw new NotFoundException("User cannot change phone number! Only the administrator can..");
        }
    }

    public static void checkPhone(boolean found) {
        if (found) {
            throw new NotFoundException("Phone number already exists!");
        }
    }
}