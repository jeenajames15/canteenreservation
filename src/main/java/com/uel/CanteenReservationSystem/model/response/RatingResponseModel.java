package com.uel.CanteenReservationSystem.model.response;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class RatingResponseModel {

    private String ratingId;

    private Long rating;

    private String userName;

    private String review;

    private String foodId;

    private Boolean active;

    private String createUserID;

    private String updateUserID;

    private OffsetDateTime createDate;

    private OffsetDateTime updateDate;
}
