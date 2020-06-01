package com.web.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.entities.Loan;
import com.web.entities.Repayment;
import com.web.repositories.LoanRepository;
import com.web.repositories.RepaymentRepository;

import javassist.NotFoundException;

@RestController
public class RepaymentController {
	
	@Autowired
	LoanRepository	loanRepository;
	
	@Autowired
	RepaymentRepository repaymentRepository;
	
	@GetMapping("/loans/{loanid}/repayments")
	public List<Repayment> getAllRepaymentsPerLoan(@PathVariable Long loanid) {
		Optional<Loan> loanee = loanRepository.findById(loanid);
		return loanee.get().getRepayments();
		
	}
	@PostMapping("/loans/{loanid}/repayments")
	public Repayment createRepayment(@PathVariable Long loanid, @RequestBody Repayment repayment) {
		Optional<Loan> loanOptional = loanRepository.findById(loanid);
			
			Loan loan=loanOptional.get();
			repayment.setLoan(loan);
			return repaymentRepository.save(repayment);
		
	}

}
