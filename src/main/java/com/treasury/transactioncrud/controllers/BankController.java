package com.treasury.transactioncrud.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.treasury.transactioncrud.entity.BankObject;
import com.treasury.transactioncrud.entity.TransactionModel;
import com.treasury.transactioncrud.repository.BankRepository;
import com.treasury.transactioncrud.repository.TreasureTransactionRepository;

@RestController
@RequestMapping("/api/Q2")
public class BankController {
	
	@Autowired
	BankRepository repo;
	
	@PostMapping("/bank")
    public ResponseEntity<BankObject> createBank(@RequestBody BankObject bank){
		
		System.out.println(bank);
		BankObject response=repo.save(bank);
		
		return new ResponseEntity<BankObject>(response,HttpStatus.CREATED);
    }
	

}
