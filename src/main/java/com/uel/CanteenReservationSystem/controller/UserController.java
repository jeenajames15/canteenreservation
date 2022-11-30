package com.uel.CanteenReservationSystem.controller;

import com.uel.CanteenReservationSystem.model.request.UserRequestModel;
import com.uel.CanteenReservationSystem.model.response.UserResponseModel;
import com.uel.CanteenReservationSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/rest/v1")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users/{userId}")
    ResponseEntity<UserResponseModel> getUser(@PathVariable String userId) {
       return ResponseEntity.ok(userService.getUser(userId));
    }

    @GetMapping("/users")
    ResponseEntity<List<UserResponseModel>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PutMapping("/users/{userId}")
    ResponseEntity<UserResponseModel> update(@RequestBody UserRequestModel userRequestModel, @PathVariable String userId) {
        return ResponseEntity.ok(userService.update(userRequestModel,userId));
    }
}
