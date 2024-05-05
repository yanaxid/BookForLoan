package menu;

import java.util.List;
import java.util.Scanner;

import book.BookForLoan;
import book.LoanBookOrder;
import member.Member;
import service.InputValidation;

public class LoanBookOrderMenu {
    Scanner sc = new Scanner(System.in);

    public void loanOrderMenu(List<BookForLoan> books, List<Member> members, List<LoanBookOrder> loanOrder,
	    MainMenu mainMenu) {

	if (loanOrder.size() != 0) {
	    
	    loanOrderMenuDisplay(loanOrder, books);
	    System.out.println("   Main Menu > Loan Book Order Menu");
	    loanOrderMenuSub1(books, members, loanOrder, mainMenu);
	} else {
	    
	    System.out.printf("   +----------------------------+");
	    System.out.println();
	    System.out.printf("   |   Data loan order kosong   |");
	    System.out.println();
	    System.out.printf("   +----------------------------+");
	    System.out.println();
	    System.out.println("   Main Menu > Loan Book Order Menu");
	    loanOrderMenuSub1(books, members, loanOrder, mainMenu);
	}

    }
    
    
    public void loanOrderMenuDisplay(List<LoanBookOrder> loanOrder, List<BookForLoan> books) {
	
	
	// cari panjang string untuk kolom member dan author > simpan dalam array
	int[] columnWidth = { 0, 0 };
	for (int i = 0; i < loanOrder.size(); i++) {
	    if (loanOrder.get(i).getMember().getMemberName().length() > columnWidth[0] || columnWidth[0] == 0) {
		columnWidth[0] = loanOrder.get(i).getMember().getMemberName().length();
	    }
	    if (loanOrder.get(i).getBookForLoan().getTitle().length() > columnWidth[1] || columnWidth[1] == 0) {
		columnWidth[1] = loanOrder.get(i).getBookForLoan().getTitle().length();
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
	System.out.println("   DATA LOAN ORDER");

	
	String columnSpace = " | ";
	String lineString = "   +-------+------------+" + listStringLength[0] + "+------------+"+ listStringLength[1] +"+------------+------------+--------------+";

	System.out.printf(lineString);
	System.out.println();

	System.out.printf(
		"   |   %-3s" + columnSpace + "%-10s" + columnSpace + "%-" + columnWidth[0] + "s" + columnSpace + "%-10s" + columnSpace + "%-" + columnWidth[1] + "s" + columnSpace
			+ "%10s" + columnSpace + "%10s" + columnSpace + "%10s   |%n",
		"No.", "Loan ID", "Name", "Book ID", "Title", "Loan Price", "Duration", "Loan Fee");
	System.out.printf(lineString);
	System.out.println();
	int i = 1;
	for (LoanBookOrder b : loanOrder) {
	    System.out.printf(
		    "   |   %-3s" + columnSpace + "%-10s" + columnSpace + "%-" + columnWidth[0] + "s" + columnSpace + "%-10s" + columnSpace + "%-" + columnWidth[1]
			    + "s" + columnSpace + "%10s" + columnSpace + "%10s" + columnSpace + "%10s   |%n",
		    i, b.getLoanId(), b.getMember().getMemberName(), b.getBookForLoan().getBookId(),
		    b.getBookForLoan().getTitle(), String.format("%,.0f", (double) (b.getLoanFee()/b.getLoanDuration())) , b.getLoanDuration(),
		    String.format("%,.0f", b.getLoanFee()));
	    i++;
	}
	System.out.printf(lineString);
	System.out.println();
    }
    
    public void loanOrderMenuSub1(List<BookForLoan> books, List<Member> members, List<LoanBookOrder> loanOrder,
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
	    default:{
		System.out.println("   Inputan tidak sesuai daftar menu!");
		loanOrderMenuSub1(books, members, loanOrder, mainMenu);
		break;
	    }
	 }
	    
	}else {
	    System.out.println("   Inputan harus angka!");
	    loanOrderMenuSub1(books, members, loanOrder, mainMenu);
	}
	
	
    }
}
