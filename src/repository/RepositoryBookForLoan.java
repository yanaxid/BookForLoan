package repository;

import java.util.ArrayList;
import java.util.List;

import book.BookForLoan;
import book.Comic;
import book.Novel;

public class RepositoryBookForLoan {


    public List<BookForLoan> getAllBookForLoan(){

        List<BookForLoan> listBook = new ArrayList<BookForLoan>();
        
        BookForLoan c1 = new Comic("Comic-001", "Uzumaki Naruto", "Masashi Kisimoto", 55000, 10, "Shounen");
        BookForLoan c2 = new Comic("Comic-002", "The Worst Client", "Masashi Kisimoto", 35000, 20, "Shounen");
        BookForLoan c3 = new Comic("Comic-003", "For the Sake of Dreams...!!", "Masashi Kisimoto", 35000, 15, "Shounen");
        BookForLoan c4 = new Comic("Comic-004", "Hunter X Hunter : The Day of Departure", "Yoshihiro Togashi", 50000, 15, "Fantasy");
        BookForLoan c5 = new Comic("Comic-005", "Hunter X Hunter : A Struggle in the Mist", "Yoshihiro Togashi", 80000, 25, "Fantasy");
        
        
        BookForLoan n1 = new Novel("Novel-001", "Harry Potter and the Philosopher's Stone", "J.K Rowling", 150000, 10, true);
        BookForLoan n2 = new Novel("Novel-002", "Harry Potter and the Chamber of Secrets", "J.K Rowling", 150000, 10, true);
        BookForLoan n3 = new Novel("Novel-003", "Harry Potter and the Prisoner of Azkaban", "J.K Rowling", 200000, 15, true);
        BookForLoan n4 = new Novel("Novel-004", "Ayah Aku Berbeda", "Tere Liye", 35000, 15, false);
        BookForLoan n5 = new Novel("Novel-005", "Madre", "Dee Lestari", 80000, 10, false);
        
        
        listBook.add(c1);
        listBook.add(c2);
        listBook.add(c3);
        listBook.add(c4);
        listBook.add(c5);
        
        listBook.add(n1);
        listBook.add(n2);
        listBook.add(n3);
        listBook.add(n4);
        listBook.add(n5);

        

        return listBook;
    }
    
}
