package com.uel.CanteenReservationSystem.service;

import com.uel.CanteenReservationSystem.model.request.TransactionRequestModel;
import com.uel.CanteenReservationSystem.model.response.TransactionResponseModel;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TransactionService {

    TransactionResponseModel save(TransactionRequestModel transactionRequestModel);

    TransactionResponseModel getById(String transactionId);

    TransactionResponseModel getByOrderId(String orderId);

    List<TransactionResponseModel> getAllByUserId(String userId);

    List<TransactionResponseModel> getAllTransactions();
}
