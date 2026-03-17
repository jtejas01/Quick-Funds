package com.app.quickFund.entities;

import jakarta.persistence.*;

@Entity
public class RefreshToken {
    @Id
    @GeneratedValue
    private Long id;
    private String tokenHash;
    private boolean revoked;

    private String deviceInfo;
    private String ipAddress;

    @ManyToOne
    private UserEntity user;

}
