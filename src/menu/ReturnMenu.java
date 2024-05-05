package menu;

import java.util.List;
import java.util.Scanner;

import book.BookForLoan;
import book.LoanBookOrder;
import member.Member;
import service.InputValidation;

public class ReturnMenu {

    InputValidation iv = new InputValidation();
    Scanner sc = new Scanner(System.in);

    public void returnMenu(List<BookForLoan> books, List<Member> members, List<LoanBookOrder> loanOrder,
	    MainMenu mainMenu) {

	if (loanOrder.size() > 0) {
	    LoanBookOrderMenu lbo = new LoanBookOrderMenu();
	    lbo.loanOrderMenuDisplay(loanOrder, books);
	    returnMenuSub1(books, members, loanOrder, mainMenu);
	} else {

	    System.out.printf("   +----------------------------+");
	    System.out.println();
	    System.out.printf("   |   Data loan order kosong   |");
	    System.out.println();
	    System.out.printf("   +----------------------------+");
	    System.out.println();
	    System.out.println("   Main Menu > Return Menu");
	    returnMenuSub2(books, members, loanOrder, mainMenu);
	}

    }

    public void returnMenuSub1(List<BookForLoan> books, List<Member> members, List<LoanBookOrder> loanOrder,
	    MainMenu mainMenu) {

	System.out.println("   Main Menu > Return Menu");
	System.out.println("   1. Return");
	System.out.println("   0. Exit");
	System.out.print("   -> ");
	String x = sc.next();
	

	if (iv.isNumber(x)) {
	    switch (Integer.valueOf(x)) {
	    case 1: {
		returnMenuSub0(books, loanOrder);
		returnMenu(books, members, loanOrder, mainMenu);
		break;

	    }
	    case 0: {
		break;
	    }
	    default: {
		System.out.println("   Inputan tidak sesuai daftar menu!");
		returnMenuSub1(books, members, loanOrder, mainMenu);
		break;
	    }

	    }
	}else {
	    System.out.println("   Inputan harus angka!");
	    returnMenuSub1(books, members, loanOrder, mainMenu);
	}

    }

    public void returnMenuSub0(List<BookForLoan> books, List<LoanBookOrder> loanOrder) {

	System.out.println("   Form Return");
	System.out.print("   Loan Id: ");
	sc.nextLine();
	String loanId = sc.nextLine();

	boolean status = false;

	for (int i = 0; i < loanOrder.size(); i++) {
	    if (loanOrder.get(i).getLoanId().equalsIgnoreCase(loanId)) {

		for (int n = 0; n < books.size(); n++) {
		    if (books.get(n).getBookId().equalsIgnoreCase(loanOrder.get(i).getBookForLoan().getBookId())) {
			books.get(n).setStock(books.get(n).getStock() + 1);
			books.get(i).calculateBookLoanPrice();
		    }
		}

		loanOrder.remove(i);
		status = true;
	    }
	}

	if (status) {
	    System.out.println("   return suskses");
	} else {
	    System.out.println("   gagal return! Loan id tidak terdaftar");
	}

    }

    public void returnMenuSub2(List<BookForLoan> books, List<Member> members, List<LoanBookOrder> loanOrder,
	    MainMenu mainMenu) {

	System.out.println("   0. Exit");
	System.out.print("   -> ");
	String x = sc.next();
	
	if(iv.isNumber(x)) {
	    switch (Integer.valueOf(x)) {
		case 0: {
		    break;

		}
		default: {
		    System.out.println("   Inputan tidak sesuai daftar menu!");
		    returnMenuSub2(books, members, loanOrder, mainMenu);
		    break;
		}
	    }
	}else {
	    System.out.println("   Inputan harus angka!");
	    returnMenuSub2(books, members, loanOrder, mainMenu);
	}

	
    }
}
