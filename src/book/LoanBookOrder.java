package book;

import iface.ILoanFeeCalculation;
import member.Member;

public class LoanBookOrder implements ILoanFeeCalculation {
    private String loanId;
    private Member member;
    BookForLoan bookForLoan;
    private int loanDuration;
    private double loanFee;

    public LoanBookOrder() {
    };

    public LoanBookOrder(String loanId, Member member, BookForLoan bookForLoan, int loanDuration) {
	this.loanId = loanId;
	this.member = member;
	this.bookForLoan = bookForLoan;
	this.loanDuration = loanDuration;
	
	calculateLoalFee();
    }

    @Override
    public void calculateLoalFee() {
	double sum = getLoanDuration() * bookForLoan.getBookLoanPrice();
	setLoanFee(sum);
    }

    public String getLoanId() {
	return loanId;
    }

    public void setLoanId(String loanId) {
	this.loanId = loanId;
    }

    public Member getMember() {
	return member;
    }

    public void setMember(Member member) {
	this.member = member;
    }

    public BookForLoan getBookForLoan() {
	return bookForLoan;
    }

    public void setBookForLoan(BookForLoan bookForLoan) {
	this.bookForLoan = bookForLoan;
    }

    public int getLoanDuration() {
	return loanDuration;
    }

    public void setLoanDuration(int loanDuration) {
	this.loanDuration = loanDuration;
    }

    public double getLoanFee() {
	return loanFee;
    }

    public void setLoanFee(double loanFee) {
	this.loanFee = loanFee;
    }
}
