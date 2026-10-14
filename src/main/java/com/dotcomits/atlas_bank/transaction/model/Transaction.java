package com.dotcomits.atlas_bank.transaction.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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

@Entity 
@Table (name = "transactions")
@Getter 
@Setter 
@NoArgsConstructor 
@AllArgsConstructor 
@EqualsAndHashCode 
public class Transaction {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column (name = "type", nullable = false, length = 20)
    private String type;

    @Column (name = "source_account_id", nullable = false)
    private Long sourceAccountId;

    @Column (name = "target_account_id", nullable = false)
    private Long targetAccountId;

    @Column (name = "amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    @Column (name = "fee", nullable = false, precision = 10, scale = 2)
    private BigDecimal fee;

    @Column (name = "status", nullable = false)
    private String status;

    @Column (name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist 
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        if (status== null) status = "PENDING";
        if (fee == null) fee = BigDecimal.ZERO;
    }
}
