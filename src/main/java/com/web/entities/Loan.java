package com.web.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="loans")
public class Loan {
	
	@Id
	@GeneratedValue
	@Column(name="loanid")
	private Long loanId;
	
	@Column(name="membername")
	private String memberName;
	
	@Column(name="loanamount")
	private Double loanAmount;

	@OneToMany(mappedBy = "loan")
	private List<Repayment> repayments;
	
	public Loan() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Loan [loanId=" + loanId + ", memberName=" + memberName + ", loanAmount=" + loanAmount + "]";
	}

	public Long getLoanId() {
		return loanId;
	}

	public void setLoanId(Long loanId) {
		this.loanId = loanId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public Double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public List<Repayment> getRepayments() {
		return repayments;
	}

	public void setRepayments(List<Repayment> repayments) {
		this.repayments = repayments;
	}

	
	
	

}
