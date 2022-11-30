package com.uel.CanteenReservationSystem.service;

import com.uel.CanteenReservationSystem.model.request.LoginModel;
import com.uel.CanteenReservationSystem.model.request.UserRequestModel;
import com.uel.CanteenReservationSystem.model.response.UserResponseModel;

import java.util.List;

public interface UserService {

    UserResponseModel save(UserRequestModel userRequestModel);

    UserResponseModel getUser(String userId);

    UserResponseModel login(LoginModel loginModel);

    List<UserResponseModel> getAllUsers();

    UserResponseModel update(UserRequestModel userRequestModel, String userId);
}
