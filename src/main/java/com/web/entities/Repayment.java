package com.web.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="repayments")
public class Repayment {
	
	@Id
	@GeneratedValue
	private Long repaymentid;
	
	@Column(name="repaymentmonth")
	private String repaymentmonth;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Loan loan;

	public Repayment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getRepaymentid() {
		return repaymentid;
	}

	public void setRepaymentid(Long repaymentid) {
		this.repaymentid = repaymentid;
	}

	public String getRepaymentMonth() {
		return repaymentmonth;
	}

	public void setRepaymentMonth(String repaymentmonth) {
		this.repaymentmonth = repaymentmonth;
	}

	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}
	
	
	


}
