package com.uel.CanteenReservationSystem.service.impl;

import com.uel.CanteenReservationSystem.entity.Menu;
import com.uel.CanteenReservationSystem.model.request.MenuRequestModel;
import com.uel.CanteenReservationSystem.model.response.MenuResponseModel;
import com.uel.CanteenReservationSystem.model.response.RatingResponseModel;
import com.uel.CanteenReservationSystem.repository.MenuRepository;
import com.uel.CanteenReservationSystem.service.MenuService;
import com.uel.CanteenReservationSystem.service.RatingService;
import com.uel.CanteenReservationSystem.util.ModelMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuRepository menuRepository;

    @Autowired
    RatingService ratingService;

    @Autowired
    private ModelMapperUtil modelMapperUtil;

    @Override
    public MenuResponseModel save(MenuRequestModel menuRequestModel) {
        return Optional.of(menuRequestModel)
                .map(modelMapperUtil::convertMenuModelToEntity)
                .map(u-> {
                    u.setActive(true);
                    u.setCreateUserID("1");
                    u.setUpdateUserID("1");
                    return u;
                })
                .map(menuRepository::save)
                .map(modelMapperUtil::convertMenuEntityToModel).get();
    }

    @Override
    public List<MenuResponseModel> getAllMenu() {
        return menuRepository.findAll()
                .stream()
                .map(modelMapperUtil::convertMenuEntityToModel)
                .map(this::updateRating)
                .collect(Collectors.toList());
    }

    @Override
    public MenuResponseModel getByID(String foodId) {
        return menuRepository.findById(foodId)
                .map(modelMapperUtil::convertMenuEntityToModel)
                .map(this::updateRating).get();
    }

    @Override
    public MenuResponseModel update(MenuRequestModel menuRequestModel, String id) {
        Menu menu = menuRepository.findById(id).get();
        menu.setAvailable(menuRequestModel.getAvailable());
        menu.setPicName(menuRequestModel.getPicName());
        menu.setCalorie(menuRequestModel.getCalorie());
        menu.setFoodClass(menuRequestModel.getFoodClass());
        menu.setFoodName(menuRequestModel.getFoodName());
        menu.setFoodDescription(menuRequestModel.getFoodDescription());
        menu.setPrice(menuRequestModel.getPrice());
        menu.setPreparationTime(menuRequestModel.getPreparationTime());
        return modelMapperUtil.convertMenuEntityToModel(menuRepository.save(menu));
    }

    @Override
    public void delete(String foodId) {
        Menu menu = menuRepository.findById(foodId).get();
        menu.setAvailable(false);
        menuRepository.save(menu);
    }

    private MenuResponseModel updateRating(MenuResponseModel menuResponseModel) {
         List<RatingResponseModel> ratingResponseModels = ratingService.getAllRatingByFoodId(menuResponseModel.getFoodId());
         if(!ratingResponseModels.isEmpty()) {
             Double avgRating = ratingResponseModels.stream()
                     .map(x -> x.getRating())
                     .collect(Collectors.toList()).stream()
                     .flatMapToInt(x -> IntStream.of(x.intValue()))
                     .average()
                     .getAsDouble();
             menuResponseModel.setAvgRating(avgRating);
             menuResponseModel.setRatings(ratingResponseModels);
         }
         return menuResponseModel;
    }
}
