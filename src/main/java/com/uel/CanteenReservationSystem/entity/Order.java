package com.uel.CanteenReservationSystem.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "ORDER", schema = "cntn")
public class Order extends BaseEntity implements Serializable{

    @Id
    @GeneratedValue(generator = "GUID")
    @GenericGenerator(name = "GUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ORDER_ID")
    private String orderId;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "TOTAL_PRICE")
    private Double totalPrice;

    @Column(name = "TOTAL_PREPARATION_TIME")
    private Integer totalPreparationTime;

    @Column(name = "ISCOMPLETED")
    private Boolean complete;
}
