package com.uel.CanteenReservationSystem.controller;

import com.uel.CanteenReservationSystem.model.request.LoginModel;
import com.uel.CanteenReservationSystem.model.request.UserRequestModel;
import com.uel.CanteenReservationSystem.model.response.UserResponseModel;
import com.uel.CanteenReservationSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/rest/v1")
public class LoginController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    ResponseEntity<UserResponseModel> login(@RequestBody LoginModel loginModel) {
       return ResponseEntity.ok(userService.login(loginModel));
    }
}
