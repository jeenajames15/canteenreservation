package com.uel.CanteenReservationSystem.repository;

import com.uel.CanteenReservationSystem.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, String> {

    List<Rating> findAllByFoodId(String foodId);
}
