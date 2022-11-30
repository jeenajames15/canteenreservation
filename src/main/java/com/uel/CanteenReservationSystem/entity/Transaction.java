package com.uel.CanteenReservationSystem.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "TRANSACTION", schema = "cntn")
public class Transaction extends BaseEntity implements Serializable{

    @Id
    @GeneratedValue(generator = "GUID")
    @GenericGenerator(name = "GUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "TRANSACTION_ID")
    private String transactionId;

    @Column(name = "ORDER_ID")
    private String orderId;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "CARD_NUMBER")
    private String cardNumber;

    @Column(name = "AMOUNT")
    private Double amount;

}
