package com.work.space.controller.user;

import com.work.space.entity.EquipmentList;
import com.work.space.service.equipment.EquipmentService;
import com.work.space.service.user.UserService;
import com.work.space.to.AuthorizedUser;
import com.work.space.to.UserProfile;
import com.work.space.to.UserTo;
import com.work.space.util.UserUtil;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Authorized User Profile Controller")
@RequestMapping(value = ProfileRestController.REST_URL)
public class ProfileRestController {

    public static final String REST_URL = "/rest/profile";

    private final UserService userService;
    private final EquipmentService equipmentService;

    public ProfileRestController(UserService userService,EquipmentService equipmentService) {

        this.userService = userService;
        this.equipmentService = equipmentService;
    }

    @GetMapping()
    public UserProfile get(@Parameter(hidden = true)
                          @AuthenticationPrincipal AuthorizedUser authorizedUser) {
        System.out.println("authorizedUser"+authorizedUser);

        List<EquipmentList> equipmentList = equipmentService.getAll(authorizedUser.getId());
        return UserUtil.asToProfile(userService.getByPhone(authorizedUser.getPhone()),equipmentList);
    }

    @GetMapping(value = "/update")
    public UserTo getUserForUpdate(
            @Parameter(hidden = true) @AuthenticationPrincipal AuthorizedUser authorizedUser) {
        return UserUtil.asTo(userService.getByPhone(authorizedUser.getPhone()));
    }

    @PutMapping(value = "/update")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody UserTo userTo,
                       @Parameter(hidden = true) @AuthenticationPrincipal AuthorizedUser authorizedUser) {
        userService.update(userTo, authorizedUser.getId());
        authorizedUser.setUserTo(userTo);
    }
}
/*
{
"id":60000,
"phone":"79000000000",
"email":"user0@mail.ru",
"firstName":"Петрddd",
"secondName":"Петроdddв",
"patronymic":"Петровdddич",
"employment_id":80001,
"address_id":10005,
"x_coordinate":543,
"y_coordinate":376,
"roles":"USER"}
 */