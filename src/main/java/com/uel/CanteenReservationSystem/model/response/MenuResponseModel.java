package com.uel.CanteenReservationSystem.model.response;

import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;

@Data
public class MenuResponseModel {

    private String foodId;

    private String foodName;

    private String foodDescription;

    private String calorie;

    private Double price;

    private Integer preparationTime;

    private String foodClass;

    private Boolean available;

    private String picName;

    private Boolean active;

    private String createUserID;

    private String updateUserID;

    private OffsetDateTime createDate;

    private OffsetDateTime updateDate;

    private Double avgRating;

    private List<RatingResponseModel> ratings;

}
