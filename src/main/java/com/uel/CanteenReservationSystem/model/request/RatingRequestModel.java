package com.uel.CanteenReservationSystem.model.request;

import lombok.Data;

@Data
public class RatingRequestModel {

    private Long rating;

    private String userName;

    private String review;

    private String foodId;
}
