package com.work.space.controller.user;

import com.work.space.entity.User;
import com.work.space.service.OtpService;
import com.work.space.service.user.UserService;
import com.work.space.to.CreateUserTo;
import com.work.space.to.UserTo;
import com.work.space.util.UserUtil;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@Tag(name = "Registration Controller")
@RequestMapping(value = RegistrationRestController.REST_URL)
public class RegistrationRestController {

    static final Logger log = LoggerFactory.getLogger(RegistrationRestController.class);
    static final String REST_URL = "/rest/users";

    private final OtpService otpService;
    private final UserService userService;

    public RegistrationRestController(OtpService otpService, UserService userService) {
        this.otpService = otpService;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserTo> create(@RequestBody CreateUserTo createUserTo) {
        System.out.println("RegistrationRestController" + createUserTo);
        log.info("Attempt to create a new user " + createUserTo.getPhone());
        //otp = one time password
        int otp = Integer.parseInt(createUserTo.getOtp());
        if (otp == otpService.getOtp(Long.parseLong(createUserTo.getPhone()))) {
            User userFromTo = UserUtil.toEntity(createUserTo);
            UserTo created = UserUtil.asTo(userService.create(userFromTo));
            URI uriOfNewUser = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/rest/admin/users" + "/{phone}")
                    .buildAndExpand(created.getPhone()).toUri();
            return ResponseEntity.created(uriOfNewUser).body(created);
        } else {
            throw new BadCredentialsException("Wrong registration password!");
        }
    }

}
