package menu;

import java.util.List;
import java.util.Scanner;

import book.BookForLoan;
import book.LoanBookOrder;
import member.Member;
import service.InputValidation;

public class BookForLoanMenu {
    Scanner sc = new Scanner(System.in);

    
    
    
    //menampilkan table 
    public void bookForLoanMenu(List<BookForLoan> books, List<Member> members, List<LoanBookOrder> loanOrder,
	    MainMenu mainMenu) {

	// cari panjang string untuk kolom title dan author > simpan dalam array

	int[] columnWidth = { 0, 0 };

	for (int i = 0; i < books.size(); i++) {
	    if (books.get(i).getTitle().length() > columnWidth[0] || columnWidth[0] == 0) {
		columnWidth[0] = books.get(i).getTitle().length();
	    }
	    if (books.get(i).getAuthor().length() > columnWidth[1] || columnWidth[1] == 0) {
		columnWidth[1] = books.get(i).getAuthor().length();
	    }
	}

	// buat string garis table "---" berasarkan panjang string

	String[] listStringLength = new String[2];

	for (int i = 0; i < columnWidth.length; i++) {
	    String line = "--";
	    for (int j = 0; j < columnWidth[i]; j++) {
		line += "-";
	    }
	    listStringLength[i] = line;
	}

	System.out.println();
	System.out.println("   DATA BOOK FOR LOAN");

	// create table
	String columnSpace = " | ";
	String lineString = "   +-------+------------+" + listStringLength[0] + "+" + listStringLength[1]
		+ "+--------+";

	System.out.printf(lineString);
	System.out.println();

	System.out.printf(
		"   |   %-3s" + columnSpace + "%-10s" + columnSpace + "%-" + columnWidth[0] + "s" + columnSpace + "%-"
			+ columnWidth[1] + "s" + columnSpace + "%-4s   |%n",
		"No.", "Book ID", "Title", "Author", "Stok");
	System.out.printf(lineString);
	System.out.println();
	int i = 1;
	for (BookForLoan b : books) {
	    System.out.printf(
		    "   |   %-3s" + columnSpace + "%-10s" + columnSpace + "%-" + columnWidth[0] + "s" + columnSpace
			    + "%-" + columnWidth[1] + "s" + columnSpace + "%-4s   |%n",
		    i, b.getBookId(), b.getTitle(), b.getAuthor(), b.getStock());
	    i++;
	}

	System.out.printf(lineString);
	System.out.println();

    }

    
    //menampilkan menu
    public void bookLoanMenuSub1(List<BookForLoan> books, List<Member> members, List<LoanBookOrder> loanOrder,
	    MainMenu mainMenu) {

	InputValidation iv = new InputValidation();

	System.out.println("   0. Exit");
	System.out.print("   -> ");
	String z = sc.next();

	if (iv.isNumber(z)) {

	    switch (Integer.valueOf(z)) {
        	    case 0: {
        		break;
        	    }
        	    default: {
        		System.out.println("   Inputan tidak sesuai daftar menu!");
        		this.bookLoanMenuSub1(books, members, loanOrder, mainMenu);
        		break;
        	    }
	    }

	} else {
	    System.out.println("   Inputan harus angka!");
	    this.bookLoanMenuSub1(books, members, loanOrder, mainMenu);
	}

    }

}
