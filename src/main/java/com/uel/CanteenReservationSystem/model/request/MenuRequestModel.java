package com.uel.CanteenReservationSystem.model.request;

import lombok.Data;

@Data
public class MenuRequestModel {

    private String foodName;

    private String foodDescription;

    private String calorie;

    private Double price;

    private Integer preparationTime;

    private String foodClass;

    private Boolean available;

    private String picName;

}
