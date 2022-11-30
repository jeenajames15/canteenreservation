package com.uel.CanteenReservationSystem.service;

import com.uel.CanteenReservationSystem.model.request.LoginModel;
import com.uel.CanteenReservationSystem.model.request.MenuRequestModel;
import com.uel.CanteenReservationSystem.model.request.UserRequestModel;
import com.uel.CanteenReservationSystem.model.response.MenuResponseModel;
import com.uel.CanteenReservationSystem.model.response.UserResponseModel;

import java.util.List;

public interface MenuService {

    MenuResponseModel save(MenuRequestModel menuRequestModel);

    List<MenuResponseModel> getAllMenu();

    MenuResponseModel getByID(String foodId);

    MenuResponseModel update(MenuRequestModel menuRequestModel, String id);

    void delete(String foodId);
}
