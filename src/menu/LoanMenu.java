package menu;

import java.util.List;
import java.util.Scanner;

import book.BookForLoan;
import book.LoanBookOrder;
import member.Member;
import service.BookForLoanValidation;
import service.InputValidation;
import service.MemberValidation;

public class LoanMenu {
    Scanner sc = new Scanner(System.in);

    public void loanMenu(List<BookForLoan> books, List<Member> members, List<LoanBookOrder> loanOrder,
	    MainMenu mainMenu) {

	BookForLoanMenu n = new BookForLoanMenu();
	n.bookForLoanMenu(books, members, loanOrder, mainMenu);

	InputValidation iv = new InputValidation();

	System.out.println("   Main Menu > Loan Book Menu");
	System.out.println("   1. Add Loan");
	System.out.println("   0. Exit");
	System.out.print("   -> ");
	String x = sc.next();

	if (iv.isNumber(x)) {
	    switch (Integer.valueOf(x)) {
	    case 1: {
		loanMenuSub1(books, members, loanOrder, mainMenu);
		loanMenu(books, members, loanOrder, mainMenu);
		break;
	    }
	    case 0: {
		break;
	    }
	    default: {
		System.out.println("   Inputan tidak sesuai daftar menu!");
		this.loanMenu(books, members, loanOrder, mainMenu);
		break;
	    }

	    }

	} else {
	    System.out.println("   Inputan harus angka!");
	    this.loanMenu(books, members, loanOrder, mainMenu);
	}

    }

    public void loanMenuSub1(List<BookForLoan> books, List<Member> members, List<LoanBookOrder> loanOrder,
	    MainMenu mainMenu) {

	System.out.println("   Form tambah data loan order");

	// input member id
	System.out.print("   Member Id: ");
	sc.nextLine();
	String memberId = sc.nextLine();

	MemberValidation memberValidation = new MemberValidation();
	memberValidation.memberValidation(members, memberId);

	while (memberValidation.isMemberExist() == false) {
	    System.out.println("   Ulangi! Member Id tidak terdaftar!");
	    System.out.print("   Member Id: ");
	    memberId = sc.nextLine();
	    memberValidation.memberValidation(members, memberId);
	}

	// input bookid
	System.out.print("   Book Id: ");
	String bookId = sc.nextLine();

	BookForLoanValidation bloanValidation = new BookForLoanValidation();
	bloanValidation.bookForLoanValidation(books, bookId);

	while (bloanValidation.isBookLoanExist() == false) {
	    System.out.println("   Ulangi! Book Id tidak terdaftar!");
	    System.out.print("   Book Id: ");
	    bookId = sc.nextLine();

	    bloanValidation.bookForLoanValidation(books, bookId);
	}

	// Lama pinjam
	System.out.print("   Lama Pinjam: ");
	String lamaPinjam = sc.next();

	// cek lama pinjam apakah angka / bukan
	InputValidation iv = new InputValidation();
	while (!iv.isNumber(lamaPinjam)) {
	    System.out.println("   Ulangi, lama pinjam harus berupa angka!");
	    System.out.print("   Lama Pinjam: ");
	    lamaPinjam = sc.next();
	}



	// add loan order
	if (loanOrder.size() == 0) {
	    loanOrder.add(new LoanBookOrder("Ord-001", memberValidation.getMember(), bloanValidation.getBookForLoan(),
		    Integer.valueOf(lamaPinjam)));
	} else {

	    String ss = String.valueOf(loanOrder.get(loanOrder.size() - 1).getLoanId().substring(4));
	    int index = Integer.valueOf(ss) + 1;
	    String idLoan = "Ord-00" + String.valueOf(index);

	    loanOrder.add(new LoanBookOrder(idLoan, memberValidation.getMember(), bloanValidation.getBookForLoan(),
		    Integer.valueOf(lamaPinjam)));
	}

	System.out.println("   Add loan order sukses!");

	
	//update data
	for (int i = 0; i < books.size(); i++) {

	    if (books.get(i).getBookId().equalsIgnoreCase(bloanValidation.getBookForLoan().getBookId())) {
		books.get(i).setStock(books.get(i).getStock() - 1);
		books.get(i).calculateBookLoanPrice();
	    }
	}

    }

}
