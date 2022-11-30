package com.uel.CanteenReservationSystem.model.request;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class TransactionRequestModel {

    private String orderId;

    private String userName;

    private String userId;

    private String cardNumber;

    private Double amount;
}
