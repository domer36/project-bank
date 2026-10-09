package com.dotcomits.atlas_bank.account.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity 
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
    private String accountNumber;
    private String ownerName;
    private String email;
    private String type;
    private BigDecimal balance;
    private String status;
    private LocalDateTime createdAt;

    @PrePersist 
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        if (status== null) status = "ACTIVE";
        if (balance == null) balance = BigDecimal.ZERO;
    }
}
