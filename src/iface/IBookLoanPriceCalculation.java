package iface;

public interface IBookLoanPriceCalculation {
    // <10 , >10
    double[] RATE_STOCK_PERCENTAGE  = { 0.05, 0.03 }; 
    // Comic , Novel
    double[] RATE_BOOK_TYPE_PERCENTAGE = { 0.1, 0.05 }; 

    void calculateBookLoanPrice();
}