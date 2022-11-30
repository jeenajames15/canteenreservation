package com.uel.CanteenReservationSystem.service.impl;

import com.uel.CanteenReservationSystem.model.request.RatingRequestModel;
import com.uel.CanteenReservationSystem.model.response.RatingResponseModel;
import com.uel.CanteenReservationSystem.repository.RatingRepository;
import com.uel.CanteenReservationSystem.service.RatingService;
import com.uel.CanteenReservationSystem.util.ModelMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class RatingServiceImpl implements RatingService {

    @Autowired
    RatingRepository ratingRepository;

    @Autowired
    private ModelMapperUtil modelMapperUtil;


    @Override
    public RatingResponseModel save(RatingRequestModel ratingRequestModel) {
        return Optional.of(ratingRequestModel)
                .map(modelMapperUtil::convertRatingModelToEntity)
                .map(u-> {
                    u.setActive(true);
                    u.setCreateUserID("1");
                    u.setUpdateUserID("1");
                    return u;
                })
                .map(ratingRepository::save)
                .map(modelMapperUtil::convertRatingEntityToModel)
                .get();
    }

    @Override
    public List<RatingResponseModel> getAllRatingByFoodId(String foodId) {
        return ratingRepository.findAllByFoodId(foodId).stream()
                .map(modelMapperUtil::convertRatingEntityToModel)
                .collect(Collectors.toList());
    }

    @Override
    public RatingResponseModel getByID(String ratingId) {
        return ratingRepository.findById(ratingId)
                .map(modelMapperUtil::convertRatingEntityToModel)
                .get();
    }
}
