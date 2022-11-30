package com.uel.CanteenReservationSystem.service;

import com.uel.CanteenReservationSystem.model.request.RatingRequestModel;
import com.uel.CanteenReservationSystem.model.response.RatingResponseModel;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RatingService {

    RatingResponseModel save(RatingRequestModel ratingRequestModel);

    List<RatingResponseModel> getAllRatingByFoodId(String foodId);

    RatingResponseModel getByID(String ratingId);

}
