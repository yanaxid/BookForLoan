package book;

import iface.IBookLoanPriceCalculation;

public abstract class BookForLoan extends Book implements IBookLoanPriceCalculation {

    private double bookLoanPrice;
    private int stock;

    public BookForLoan(){}  
    
    public BookForLoan(String bookId, String title, String author, double bookPrice, int stock) {
        super(bookId, title, author, bookPrice);
        this.stock = stock;
    }


    public double getBookLoanPrice() {
        return bookLoanPrice;
    }

    public void setBookLoanPrice(double bookLoanPrice) {
        this.bookLoanPrice = bookLoanPrice;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

  

}
