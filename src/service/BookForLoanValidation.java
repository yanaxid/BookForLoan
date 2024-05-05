package service;

import java.util.List;

import book.BookForLoan;

public class BookForLoanValidation {

    private BookForLoan bookForLoan = null;
    private boolean bookLoanExist = false;

    public void bookForLoanValidation(List<BookForLoan> bookForLoan, String bookId) {
	for (int i = 0; i < bookForLoan.size(); i++) {
	    if (bookForLoan.get(i).getBookId().equalsIgnoreCase(bookId)) {
		setBookLoanExist(true);
		setBookForLoan(bookForLoan.get(i));
	    }
	}
    }

    public BookForLoan getBookForLoan() {
        return bookForLoan;
    }

    public void setBookForLoan(BookForLoan bookForLoan) {
        this.bookForLoan = bookForLoan;
    }

    public boolean isBookLoanExist() {
        return bookLoanExist;
    }

    public void setBookLoanExist(boolean bookLoanExist) {
        this.bookLoanExist = bookLoanExist;
    }
    
    
    
    
}
