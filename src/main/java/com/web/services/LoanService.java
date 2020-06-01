package com.web.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.entities.Loan;
import com.web.repositories.LoanRepository;

@Service
@Transactional
public class LoanService {
	@Autowired
	LoanRepository loanRepository;
	
	//get all loans
	public List<Loan> getAllLoans() {
		return loanRepository.findAll();
		
	}
	//get loan by id(from url)
	public Optional<Loan> getLoanById(Long id) {
		return loanRepository.findById(id);
	}
	
	//create loan
	public Loan createLoan(Loan loan) {
		return loanRepository.save(loan);
		
	}
	//create loan from client
	public Loan createLoanFromClient(String memberName,Double loanAmount) {
		Loan loan = new Loan();
		loan.setMemberName(memberName);
		loan.setLoanAmount(loanAmount);
			
		return loanRepository.save(loan);
		
	}
	//update Loan
	public Loan updateLoan(Long id,Loan loan) {
		loan.setLoanId(id);
		return loanRepository.save(loan);
		
	}
	//@PersistenceContext
	public Loan updateLoanByIdFromClient(Long id, String memberName, Double loanAmount) {
		Loan loan=new Loan();
		loan.setLoanId(id);
		loan.setMemberName(memberName);
		loan.setLoanAmount(loanAmount);
		return loanRepository.save(loan);
	}
	//delete loan
	public void deleteLoan(Long id) {
		if(loanRepository.findById(id).isPresent())
			 loanRepository.deleteById(id);
	}
	

}
