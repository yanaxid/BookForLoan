package menu;

import java.util.List;
import java.util.Scanner;

import book.BookForLoan;
import book.LoanBookOrder;
import member.Member;
import service.InputValidation;

public class MainMenu {

    Scanner sc = new Scanner(System.in);
    LoanMenu loanMenu = new LoanMenu();
    ReturnMenu returnMenu = new ReturnMenu();
    BookForLoanMenu bookForLoanMenu = new BookForLoanMenu();
    LoanBookOrderMenu loanOrderMenu = new LoanBookOrderMenu();

    InputValidation iv = new InputValidation();

    public void mainMenu(List<BookForLoan> books, List<Member> members, List<LoanBookOrder> loanOrder) {
	System.out.println();
	System.out.println();
	System.out.println("APLIKASI PINJAM BUKU");
	System.out.println();
	System.out.println("Main Menu");
	System.out.println("1. Data All Book for Loan");
	System.out.println("2. Loan");
	System.out.println("3. Return");
	System.out.println("4. Data All Loan Book Order");
	System.out.println("0. Exit");

	System.out.print("-> ");
	String x = sc.next();

	if (iv.isNumber(x)) {
	    switch (Integer.valueOf(x)) {
	    case 1: {
		bookForLoanMenu.bookForLoanMenu(books, members, loanOrder, this);
		System.out.println("   Main Menu > Data All Book Loan Menu");
		bookForLoanMenu.bookLoanMenuSub1(books, members, loanOrder, this);
		break;
	    }
	    case 2: {
		loanMenu.loanMenu(books, members, loanOrder, this);
		mainMenu(books, members, loanOrder);
		break;
	    }
	    case 3: {
		returnMenu.returnMenu(books, members, loanOrder, this);
		break;
	    }
	    case 4: {
		loanOrderMenu.loanOrderMenu(books, members, loanOrder, this);
		mainMenu(books, members, loanOrder);
		break;
	    }
	    case 0: {
		break;
	    }
	    default: {
		System.out.println("   Inputan tidak sesuai daftar menu!");
		mainMenu(books, members, loanOrder);
		break;
	    }
	    }

	}else {
	    System.out.println("   Inputan harus angka!");
	    mainMenu(books, members, loanOrder);
	   
	}

    }

}
