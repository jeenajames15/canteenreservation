package com.uel.CanteenReservationSystem.util;

import com.uel.CanteenReservationSystem.entity.*;
import com.uel.CanteenReservationSystem.model.request.*;
import com.uel.CanteenReservationSystem.model.response.*;
import com.uel.CanteenReservationSystem.repository.TransactionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ModelMapperUtil {

    ModelMapper modelMapper;

    @PostConstruct
    private void createModelInstance() {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
    }

    public UserResponseModel convertUserEntityToModel(User user) {
        return modelMapper.map(user, UserResponseModel.class);
    }

    public User convertUserModelToEntity(UserRequestModel userModel) {
        return modelMapper.map(userModel, User.class);
    }

    public MenuResponseModel convertMenuEntityToModel(Menu menu) {
        return modelMapper.map(menu, MenuResponseModel.class);
    }

    public Menu convertMenuModelToEntity(MenuRequestModel menuRequestModel) {
        return modelMapper.map(menuRequestModel, Menu.class);
    }

    public OrderResponseModel convertOrderEntityToModel(Order order) {
        return modelMapper.map(order, OrderResponseModel.class);
    }

    public Order convertOrderModelToEntity(OrderRequestModel orderRequestModel) {
        return modelMapper.map(orderRequestModel, Order.class);
    }

    public RatingResponseModel convertRatingEntityToModel(Rating rating) {
        return modelMapper.map(rating, RatingResponseModel.class);
    }

    public Rating convertRatingModelToEntity(RatingRequestModel ratingRequestModel) {
        return modelMapper.map(ratingRequestModel, Rating.class);
    }

    public TransactionResponseModel convertTransactionEntityToModel(Transaction transaction) {
        return modelMapper.map(transaction, TransactionResponseModel.class);
    }

    public Transaction convertTransactionModelToEntity(TransactionRequestModel transactionRequestModel) {
        return modelMapper.map(transactionRequestModel, Transaction.class);
    }
}
