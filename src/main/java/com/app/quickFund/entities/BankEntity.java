package com.app.quickFund.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BankEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private BankName name;

    private String ifsc;

    @Column(name  = "branch_code")
    private String branchCode;

    private boolean isActive;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
