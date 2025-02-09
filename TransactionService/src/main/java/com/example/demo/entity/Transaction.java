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
    
    @Column(name = "transaction_id", nullable = false)
    private String transactionId;
    @ManyToOne
    @JoinColumn(name = "beneficiary_id") // Foreign key managed here
    private Beneficiaries beneficiary; 
    
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
    
    @ManyToOne
    @JoinColumn(name="USER_ID", nullable=false, updatable=false)
    private UserDetails userDetails;

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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSenderAccount() {
		return senderAccount;
	}
	public void setSenderAccount(String senderAccount) {
		this.senderAccount = senderAccount;
	}
	public String getSenderAccountType() {
		return senderAccountType;
	}
	public void setSenderAccountType(String senderAccountType) {
		this.senderAccountType = senderAccountType;
	}
	public String getReceiverAccount() {
		return receiverAccount;
	}
	public void setReceiverAccount(String receiverAccount) {
		this.receiverAccount = receiverAccount;
	}
	public String getReceiverAccountType() {
		return receiverAccountType;
	}
	public void setReceiverAccountType(String receiverAccountType) {
		this.receiverAccountType = receiverAccountType;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public TransactionType getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}
	public TransferType getTransferType() {
		return transferType;
	}
	public void setTransferType(TransferType transferType) {
		this.transferType = transferType;
	}
	public TransactionStatus getStatus() {
		return status;
	}
	public void setStatus(TransactionStatus status) {
		this.status = status;
	}
	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getBalanceAfterTransaction() {
		return balanceAfterTransaction;
	}
	public void setBalanceAfterTransaction(Double balanceAfterTransaction) {
		this.balanceAfterTransaction = balanceAfterTransaction;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public UserDetails getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	public Beneficiaries getBeneficiary() {
		return beneficiary;
	}
	public void setBeneficiary(Beneficiaries beneficiary) {
		this.beneficiary = beneficiary;
	}
    
    
}
