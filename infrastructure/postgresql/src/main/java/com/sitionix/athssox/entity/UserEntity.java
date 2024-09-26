package com.sitionix.athssox.entity;

import jakarta.persistence.*;

@Entity
@Table(name="USERS")
public class UserEntity {

    @Id
    @GeneratedValue()
    private Long id;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "PASSWORD")
    private String password;
}
