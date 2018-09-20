package com.treasury.transactioncrud.repository;

import org.springframework.data.repository.CrudRepository;

import com.treasury.transactioncrud.entity.BankObject;

public interface BankRepository extends CrudRepository<BankObject, Long> {

	BankObject findByBankId(int bankId);
	
}
