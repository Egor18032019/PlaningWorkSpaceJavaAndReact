package com.work.space.controller;


import com.work.space.service.OtpService;
import com.work.space.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class LoginController {

    static final Logger log = LoggerFactory.getLogger(LoginController.class);
    private final UserService userService;
    private final OtpService otpService;

    public LoginController(UserService userService, OtpService otpService) {
        this.userService = userService;
        this.otpService = otpService;
    }

    @ResponseBody
    @PostMapping("/onetimecode")
    public HashMap<String, String> getOneTimePassword(@RequestParam(value = "username") long phone) {
        System.out.println(phone);
        log.info("Authorization attempt " + phone + ".");
        //throw NotFoundException
        userService.getByPhone(phone);
        int oneTimePassword = otpService.generateOTP(phone);
        HashMap<String, String> map = new HashMap<String, String>();

        map.put("username", String.valueOf(phone));
        map.put("smsPassword", String.valueOf(oneTimePassword));
        return map;
    }

    @ResponseBody
    @PostMapping("/registration-otp")
    public HashMap<String, String> getRegistrationOneTimePassword(@RequestParam(value = "username") long phone) {

        int oneTimePassword = otpService.generateOTP(phone);
        HashMap<String, String> map = new HashMap<String, String>();

        map.put("smsPassword", String.valueOf(oneTimePassword));
        return map;
    }
}
