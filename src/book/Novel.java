package book;

public class Novel extends BookForLoan {

    private boolean isSeries;

    public Novel() {
    }

    public Novel(String bookId, String title, String author, double bookLoanPrice, int stock, boolean isSeries) {
        super(bookId, title, author, bookLoanPrice, stock);
        this.isSeries = isSeries;

        calculateBookLoanPrice();
    }

    @Override
    public void calculateBookLoanPrice() {
        double stockPercentage = 0;
        double ratePercentage = RATE_BOOK_TYPE_PERCENTAGE[0];

        if (getStock() >= 10) {
            stockPercentage = RATE_STOCK_PERCENTAGE[1];
        } else {
            stockPercentage =  RATE_STOCK_PERCENTAGE[0];
        }
        double sum = (stockPercentage + ratePercentage) * getBookPrice();
        setBookLoanPrice(sum);
    }

    public boolean isSeries() {
        return isSeries;
    }

    public void setSeries(boolean isSeries) {
        this.isSeries = isSeries;
    }

}
