package com.uel.CanteenReservationSystem.model.response;

import lombok.Data;

import java.time.OffsetDateTime;


@Data
public class UserResponseModel {

    private String userId;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private String password;

    private String address;

    private String securityQuestion;

    private String securityAnswer;

    private String userType;

    private Boolean active;

    private String createUserID;

    private String updateUserID;

    private OffsetDateTime createDate;

    private OffsetDateTime updateDate;
}
