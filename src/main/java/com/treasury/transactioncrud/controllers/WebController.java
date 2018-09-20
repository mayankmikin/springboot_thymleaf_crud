package com.treasury.transactioncrud.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.treasury.transactioncrud.entity.Distribution;
import com.treasury.transactioncrud.entity.TransactionModel;
import com.treasury.transactioncrud.repository.BankRepository;
import com.treasury.transactioncrud.repository.TreasureTransactionRepository;
@Controller
public class WebController {
	@Autowired
	TreasureTransactionRepository repo;
	
	@Autowired
	BankRepository bankrepo;
	
	// jsp or html things starts here 
	@GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("appName", "Bank Treasury Application");
        return "home";
    }
	@GetMapping("/getTransaction")
    public String transactionPage(Model model) {
		TransactionModel tmodel=new TransactionModel();
		List<Distribution>list=new ArrayList<>();
		list.add(new Distribution());
		list.add(new Distribution());
		list.add(new Distribution());
		tmodel.setDistributions(list);
		//tmodel.setSettleDate(new Date());
		model.addAttribute("transaction",tmodel);
        return "createtransaction.html";
    }
	
	@RequestMapping(value="/web/CreateTransaction",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	    public  String greetingSubmit(@ModelAttribute TransactionModel transaction,Model model) {
		// transaction.setSettleDate(new  Date());
		 transaction.setTicketNumber(UUID.randomUUID());
			System.out.println(transaction);
			TransactionModel response=repo.save(transaction);
			
			String ticketNumber=response.getTicketNumber().toString();
		 model.addAttribute("tktNumber", ticketNumber);
	        return "result";
	    }
	 
		
	/*	@RequestMapping(value="/web/CreateTransaction",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,method = RequestMethod.POST)
	    public createTransaction(@RequestBody(required = false) TransactionModel transaction){
			
			transaction.setTicketNumber(UUID.randomUUID());
			System.out.println(transaction);
			TransactionModel response=repo.save(transaction);
			
			String ticketNumber=response.getTicketNumber().toString();
			
			return new ResponseEntity<String>(ticketNumber,HttpStatus.CREATED);
	    }*/
	
}
