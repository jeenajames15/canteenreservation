package com.uel.CanteenReservationSystem.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "RATING", schema = "cntn")
public class Rating extends BaseEntity implements Serializable{

    @Id
    @GeneratedValue(generator = "GUID")
    @GenericGenerator(name = "GUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "RATING_ID")
    private String ratingId;

    @Column(name = "RATING")
    private Long rating;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "REVIEW")
    private String review;

    @Column(name = "FOOD_ID")
    private String foodId;

}
