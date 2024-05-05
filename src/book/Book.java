package book;

public abstract class Book {

    private String bookId, title, author;
    private double bookPrice;

    public Book() {
    }

    public Book(String bookId, String title, String author, double bookPrice) {
	this.bookId = bookId;
	this.title = title;
	this.author = author;
	this.bookPrice = bookPrice;
    }

    public String getBookId() {
	return bookId;
    }

    public void setBookId(String bookId) {
	this.bookId = bookId;
    }

    public String getTitle() {
	return title;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    public String getAuthor() {
	return author;
    }

    public void setAuthor(String author) {
	this.author = author;
    }

    public double getBookPrice() {
	return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
	this.bookPrice = bookPrice;
    }

}
