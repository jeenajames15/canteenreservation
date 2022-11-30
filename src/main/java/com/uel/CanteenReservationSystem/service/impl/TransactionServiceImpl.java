package com.uel.CanteenReservationSystem.service.impl;

import com.uel.CanteenReservationSystem.model.request.TransactionRequestModel;
import com.uel.CanteenReservationSystem.model.response.TransactionResponseModel;
import com.uel.CanteenReservationSystem.repository.TransactionRepository;
import com.uel.CanteenReservationSystem.service.TransactionService;
import com.uel.CanteenReservationSystem.util.ModelMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    private ModelMapperUtil modelMapperUtil;


    @Override
    public TransactionResponseModel save(TransactionRequestModel transactionRequestModel) {
        return Optional.of(transactionRequestModel)
                .map(modelMapperUtil::convertTransactionModelToEntity)
                .map(u-> {
                    u.setActive(true);
                    u.setCreateUserID("1");
                    u.setUpdateUserID("1");
                    return u;
                })
                .map(transactionRepository::save)
                .map(modelMapperUtil::convertTransactionEntityToModel)
                .get();
    }

    @Override
    public TransactionResponseModel getById(String transactionId) {
        return transactionRepository.findById(transactionId)
                .map(modelMapperUtil::convertTransactionEntityToModel)
                .get();
    }

    @Override
    public TransactionResponseModel getByOrderId(String orderId) {
        return modelMapperUtil.convertTransactionEntityToModel(transactionRepository.findByOrderId(orderId));
    }

    @Override
    public List<TransactionResponseModel> getAllByUserId(String userId) {
        return transactionRepository.findAllByUserId(userId).stream()
                .map(modelMapperUtil::convertTransactionEntityToModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<TransactionResponseModel> getAllTransactions() {
        return transactionRepository.findAll().stream()
                .map(modelMapperUtil::convertTransactionEntityToModel)
                .collect(Collectors.toList());
    }

}
