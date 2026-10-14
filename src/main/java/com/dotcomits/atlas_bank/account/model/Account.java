package com.dotcomits.atlas_bank.account.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity 
@Table (name = "accounts")
@Getter
@Setter  
@NoArgsConstructor 
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true) 
public class Account {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column (name = "account_number", unique = true, nullable = false)
    private String accountNumber;

    @Column (name = "owner_name", nullable = false)
    private String ownerName;

    @Column (name = "email", unique = true, nullable = false)
    private String email;

    @Column (name = "type", nullable = false, length = 20)
    private String type;

    @Column (name = "balance", nullable = false, precision = 10, scale = 2)
    private BigDecimal balance;

    @Column (name = "status", nullable = false)
    private String status;

    @Column (name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist 
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        if (status== null) status = "ACTIVE";
        if (balance == null) balance = BigDecimal.ZERO;
    }
}
