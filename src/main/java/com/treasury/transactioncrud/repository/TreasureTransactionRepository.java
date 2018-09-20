package com.treasury.transactioncrud.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.treasury.transactioncrud.entity.TransactionModel;

public interface TreasureTransactionRepository extends CrudRepository<TransactionModel, Long> {

	TransactionModel findByPinNumber(String pinNumber);
	TransactionModel findByTicketNumber(UUID ticketNumber);
	
}
