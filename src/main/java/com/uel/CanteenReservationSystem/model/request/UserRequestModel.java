package com.uel.CanteenReservationSystem.model.request;

import lombok.Data;


@Data
public class UserRequestModel {

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private String password;

    private String address;

    private String securityQuestion;

    private String securityAnswer;

    private String userType;

}
