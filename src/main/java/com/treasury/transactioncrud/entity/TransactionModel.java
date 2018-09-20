package com.treasury.transactioncrud.entity;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "transactions")
public class TransactionModel {
	


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Size(min=3, max=50)
	@NotNull
	@Column(name = "TRANSACTION_TYPE", nullable = false)
	private String transactionType;

	@NotNull
	@Column(name = "SETTLE_DATE", nullable = false)
	//@Temporal(TemporalType.TIMESTAMP)
	//@CreatedDate
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime  settleDate;

	@NotNull
	@Digits(integer=8, fraction=2)
	@Column(name = "AMOUNT", nullable = false)
	private BigDecimal amount;
	
	@Column(name = "DESTINATION_ID", nullable = false)
	private int destinationId;

	@NotEmpty
	@Column(name = "PIN_NUMBER", nullable = false)
	private String pinNumber;
	
	@NotEmpty
	@Column(name = "IP_ADDRESS", nullable = false)
	private String ipaddress;
	
	@Column(name = "DISTRIBUTIONS" )
	@OneToMany(mappedBy="transaction", fetch=FetchType.LAZY)
	private List<Distribution> distributions=new ArrayList<>();
	
	@Column(name = "TICKET_NUMBER", nullable = false)
	private UUID ticketNumber;
	
	@Column(name = "NOTES", nullable = false)
	private String notes;
	
	@Column(name = "STATUS", nullable = false)
	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}



	public String getPinNumber() {
		return pinNumber;
	}

	public void setPinNumber(String pinNumber) {
		this.pinNumber = pinNumber;
	}

	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	public List<Distribution> getDistributions() {
		return distributions;
	}

	public void setDistributions(List<Distribution> distributions) {
		this.distributions = distributions;
	}

	public UUID getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(UUID ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public int getDestinationId() {
		return destinationId;
	}

	public void setDestinationId(int destinationId) {
		this.destinationId = destinationId;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getSettleDate() {
		return settleDate;
	}

	public void setSettleDate(LocalDateTime settleDate) {
		this.settleDate = settleDate;
	}

	@Override
	public String toString() {
		return "TransactionModel [id=" + id + ", transactionType=" + transactionType + ", settleDate=" + settleDate
				+ ", amount=" + amount + ", destinationId=" + destinationId + ", pinNumber=" + pinNumber
				+ ", ipaddress=" + ipaddress + ", distributions=" + distributions + ", ticketNumber=" + ticketNumber
				+ ", notes=" + notes + ", status=" + status + "]";
	}

	
	
	
}