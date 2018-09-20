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
public class TransactionController {
	
	@Autowired
	TreasureTransactionRepository repo;
	
	@Autowired
	BankRepository bankrepo;
	
	@PostMapping("/CreateTransaction")
    public ResponseEntity<String> createTransaction(@RequestBody TransactionModel transaction){
		
		transaction.setTicketNumber(UUID.randomUUID());
		System.out.println(transaction);
		TransactionModel response=repo.save(transaction);
		
		String ticketNumber=response.getTicketNumber().toString();
		
		return new ResponseEntity<String>(ticketNumber,HttpStatus.CREATED);
    }

	@GetMapping("/GetDestination/{pin}")
	public ResponseEntity<BankObject> getBankInfo(@PathVariable Integer pin){
		
		System.out.println("transaction model is");
		TransactionModel tm=repo.findByPinNumber(pin.toString());
		System.out.println(tm);
		BankObject response=bankrepo.findByBankId(tm.getDestinationId());
		System.out.println("bank object is");
		System.out.println(response);
		return new ResponseEntity<BankObject>(response,HttpStatus.OK);
    }
	/*@RequestMapping("/TNTRSRY/UpdateStatus")
    public ResponseEntity<TransactionModel> updateTransaction(@RequestParam("TKTNumber") UUID TKTNumber, 
    		@RequestParam("Pin") String Pin,@RequestParam("Status") String Status,@RequestParam("Notes") String Notes){
		
		System.out.println("update transaction is called ticket  number is ");
		System.out.println(TKTNumber);
		TransactionModel model=repo.findByTicketNumber(TKTNumber);
		model.setNotes(Notes);
		//model.setStatus(Status);
		repo.save(model);
		
		return new ResponseEntity<TransactionModel>(model,HttpStatus.ACCEPTED);
    }*/
	@PostMapping("/TNTRSRY/UpdateStatus/{TKTNumber}/{Pin}/{Status}/{Notes}")
    public ResponseEntity<TransactionModel> updateTransaction(@PathVariable UUID TKTNumber, 
    		@PathVariable String Pin,@PathVariable String Status,@PathVariable String Notes){
		
		System.out.println("update transaction is called ticket  number is ");
		System.out.println(TKTNumber);
		TransactionModel model=repo.findByTicketNumber(TKTNumber);
		model.setNotes(Notes);
		//model.setStatus(Status);
		repo.save(model);
		
		return new ResponseEntity<TransactionModel>(model,HttpStatus.ACCEPTED);
    }
	
	
	@GetMapping("/checkTicketstatus/{tktNumber}")
	public ResponseEntity<TransactionModel> getTransactionInfo(@PathVariable UUID tktNumber){
		
		System.out.println("transaction model is");
		TransactionModel tm=repo.findByTicketNumber(tktNumber);
		System.out.println(tm);
		
		return new ResponseEntity<TransactionModel>(tm,HttpStatus.OK);
    }
	

	
}
