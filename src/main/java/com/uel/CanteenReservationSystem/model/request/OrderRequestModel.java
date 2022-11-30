package com.uel.CanteenReservationSystem.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.uel.CanteenReservationSystem.model.response.MenuResponseModel;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderRequestModel {

    private String orderId;

    private String userName;

    private String userId;

    private Double totalPrice;

    private Integer totalPreparationTime;

    private List<MenuResponseModel> menuItems;

    private Boolean complete;
}
