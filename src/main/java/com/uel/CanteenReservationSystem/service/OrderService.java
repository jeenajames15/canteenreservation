package com.uel.CanteenReservationSystem.service;

import com.uel.CanteenReservationSystem.model.request.LoginModel;
import com.uel.CanteenReservationSystem.model.request.OrderRequestModel;
import com.uel.CanteenReservationSystem.model.request.UserRequestModel;
import com.uel.CanteenReservationSystem.model.response.OrderResponseModel;
import com.uel.CanteenReservationSystem.model.response.UserResponseModel;

import java.util.List;

public interface OrderService {

    OrderResponseModel save(OrderRequestModel orderRequestModel);

    OrderResponseModel getOrder(String orderId);

    List<OrderResponseModel> getAllOrder();

    List<OrderResponseModel> getOrderByUserId(String userId);

    void cancelOrder(String orderId);

    OrderResponseModel completeOrder(String orderId, String time);

}
