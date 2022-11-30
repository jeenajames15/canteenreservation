package com.uel.CanteenReservationSystem.controller;

import com.uel.CanteenReservationSystem.model.request.RatingRequestModel;
import com.uel.CanteenReservationSystem.model.response.RatingResponseModel;
import com.uel.CanteenReservationSystem.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/rest/v1")
public class RatingController {

    @Autowired
    RatingService ratingService;

    @PostMapping("/ratings")
    ResponseEntity<RatingResponseModel> save(@RequestBody RatingRequestModel ratingRequestModel) {
        return ResponseEntity.ok(ratingService.save(ratingRequestModel));
    }

    @GetMapping("/ratings/food/{foodId}")
    ResponseEntity<List<RatingResponseModel>> getAllRatingByFoodId(@PathVariable String foodId) {
        return ResponseEntity.ok(ratingService.getAllRatingByFoodId(foodId));
    }

    @GetMapping("/ratings/{ratingId}")
    ResponseEntity<RatingResponseModel> getById(@PathVariable String ratingId) {
        return ResponseEntity.ok(ratingService.getByID(ratingId));
    }

}
