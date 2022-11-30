package com.uel.CanteenReservationSystem.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "USER", schema = "cntn")
public class User extends BaseEntity implements Serializable{

    @Id
    @GeneratedValue(generator = "GUID")
    @GenericGenerator(name = "GUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "SECURITY_QUESTION")
    private String securityQuestion;

    @Column(name = "SECURITY_ANSWER")
    private String securityAnswer;

    @Column(name = "USER_TYPE")
    private String userType;

}
