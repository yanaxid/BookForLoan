package book;

public class Comic extends BookForLoan {
    private String genre;

    public Comic() {
    }

    public Comic(String bookId, String title, String author, double bookPrice, int stock, String genre) {
        super(bookId, title, author, bookPrice, stock);
        this.genre = genre;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

}
