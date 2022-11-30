package com.uel.CanteenReservationSystem.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "ORDER_MENU", schema = "cntn")
public class OrderMenu extends BaseEntity implements Serializable{


    @EmbeddedId
    private OrderMenuID orderMenuID = new OrderMenuID();

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @LazyToOne(LazyToOneOption.NO_PROXY)
    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
    @JoinColumn(name = "ORDER_ID", insertable = false, updatable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "FOOD_ID", insertable = false, updatable = false)
    private Menu menu;
}
