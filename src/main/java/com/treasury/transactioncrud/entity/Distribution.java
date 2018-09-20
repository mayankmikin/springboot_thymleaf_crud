package com.treasury.transactioncrud.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="distribution")
public class Distribution {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(updatable=false, unique=true, nullable=false)
    private Long id;
	
    @Column(updatable=false)
	private String accountNumber;
    
    @Column(updatable=false)
	private BigDecimal amount;
	
    @ManyToOne(fetch=FetchType.LAZY)
	private TransactionModel transaction;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public TransactionModel getTransaction() {
		return transaction;
	}

	public void setTransaction(TransactionModel transaction) {
		this.transaction = transaction;
	}

	@Override
	public String toString() {
		return "Distribution [id=" + id + ", accountNumber=" + accountNumber + ", amount=" + amount + ", transaction="
				+ transaction + "]";
	}
    

}
