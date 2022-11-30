package com.uel.CanteenReservationSystem.model.response;

import lombok.Data;

import javax.persistence.Column;
import java.time.OffsetDateTime;

@Data
public class TransactionResponseModel {

    private String transactionId;

    private String orderId;

    private String userName;

    private String userId;

    private String cardNumber;

    private Double amount;

    private Boolean active;

    private String createUserID;

    private String updateUserID;

    private OffsetDateTime createDate;

    private OffsetDateTime updateDate;
}
