package com.uel.CanteenReservationSystem.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "MENU", schema = "cntn")
public class Menu extends BaseEntity implements Serializable{

    @Id
    @GeneratedValue(generator = "GUID")
    @GenericGenerator(name = "GUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "FOOD_ID")
    private String foodId;

    @Column(name = "FOOD_NAME")
    private String foodName;

    @Column(name = "FOOD_DESCRIPTION")
    private String foodDescription;

    @Column(name = "CALORIE")
    private String calorie;

    @Column(name = "PRICE")
    private Double price;

    @Column(name = "PREPARATION_TIME")
    private Integer preparationTime;

    @Column(name = "FOOD_CLASS")
    private String foodClass;

    @Column(name = "PIC_NAME")
    private String picName;

    @Column(name = "ISAVAILABLE")
    private Boolean available;

}
