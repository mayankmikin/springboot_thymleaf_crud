package com.treasury.transactioncrud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bank")
public class BankObject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "BRANCH_NUMBER", nullable = false)
	private int branchNumber;
	
	@Column(name = "ACCOUNT_NUMBER", nullable = false)
	private int accountNumber;
	
	@Column(name = "ACCOUNT_TYPE", nullable = false)
	private int accountType;
	
	@Column(name = "ACCOUNT_NAME", nullable = false)
	private String accountName;
	
	@Column(name = "BANK_ID",unique=true, nullable = false)
	private int bankId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBranchNumber() {
		return branchNumber;
	}

	public void setBranchNumber(int branchNumber) {
		this.branchNumber = branchNumber;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getAccountType() {
		return accountType;
	}

	public void setAccountType(int accountType) {
		this.accountType = accountType;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	@Override
	public String toString() {
		return "BankObject [id=" + id + ", branchNumber=" + branchNumber + ", accountNumber=" + accountNumber
				+ ", accountType=" + accountType + ", accountName=" + accountName + ", bankId=" + bankId + "]";
	}





	
	
	

}
