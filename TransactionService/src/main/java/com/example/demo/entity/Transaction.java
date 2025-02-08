package com.example.demo.entity;


import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.example.demo.model.TransactionStatus;
import com.example.demo.model.TransactionType;
import com.example.demo.model.TransferType;

@Entity
@Table(name = "transactions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sender_account_id", nullable = false)
    private String senderAccount;
    
    @Column(name="sender_account_type", nullable =false)
    private String senderAccountType;

    @Column(name = "receiver_account_id", nullable = false)
    private String receiverAccount;
    
    @Column(name="receiver_account_type", nullable =false)
    private String receiverAccountType;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionType transactionType;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransferType transferType;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionStatus status;
    
    @Column(name = "created_at", columnDefinition = "TIMESTAMP")
	private LocalDateTime 	transactionDate; 
	@Column
	private String	description;
	@Column
	private	Double balanceAfterTransaction;
    @PrePersist
    protected void onCreate() {
        this.transactionDate = LocalDateTime.now();
    }
}
