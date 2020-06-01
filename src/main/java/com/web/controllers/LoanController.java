package com.web.controllers;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.entities.Loan;
import com.web.services.LoanService;

@RestController
@RequestMapping(value="/loans")
public class LoanController {

	@Autowired
	LoanService loanService;
	@GetMapping
	public List<Loan> getAllLoans(){
		return loanService.getAllLoans();
	}
	@GetMapping("/{id}")
	public Optional<Loan> getLoanById(@PathVariable("id") Long id) {
		return loanService.getLoanById(id);
	}
	@GetMapping("/idfromclient")
	public Optional<Loan> getLoanByIdFromClient(@PathParam("id") Long id) {
		return loanService.getLoanById(id);
	}
	@PostMapping
	public Loan createLoan(@RequestBody Loan loan) {
		return loanService.createLoan(loan);
		
	}
	@PostMapping("/createloanfromclient")
	public Loan createLoanFromClient(@PathParam("membername") String membername,
			@PathParam("loanamount") Double loanamount) {
		return loanService.createLoanFromClient(membername, loanamount);
	}
	@PutMapping("/{id}")
	public Loan updateLoan(@PathVariable("id") Long id,@RequestBody Loan loan) {
		return loanService.updateLoan(id, loan);
	}
	@PutMapping("idfromclient/{id}")
	public Loan updateLoanByIdFromClient(
			@PathVariable("id") Long id,
			@PathParam("membername") String membername, 
			@PathParam("loanamount") Double loanamount) {
		return loanService.updateLoanByIdFromClient(id, membername, loanamount);
	}
	@DeleteMapping("/{id}")
	public void deleteLoan(@PathVariable("id") Long id) {
		loanService.deleteLoan(id);
	}
}
