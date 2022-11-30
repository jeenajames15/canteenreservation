package com.uel.CanteenReservationSystem.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderResponseModel {

    private String orderId;

    private String userName;

    private String userId;

    private Double totalPrice;

    private Integer totalPreparationTime;

    private Boolean complete;

    private List<MenuResponseModel> menuItems;

    private Boolean active;

    private String createUserID;

    private String updateUserID;

    private OffsetDateTime createDate;

    private OffsetDateTime updateDate;
}
