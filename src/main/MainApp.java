package main;

import java.util.ArrayList;
import java.util.List;

import book.BookForLoan;
import book.LoanBookOrder;
import member.Member;
import menu.MainMenu;
import repository.RepositoryBookForLoan;
import repository.RepositoryMember;

public class MainApp {

    public static void main(String[] args) {

	RepositoryBookForLoan repoBooks = new RepositoryBookForLoan();
	RepositoryMember repoMembers = new RepositoryMember();

	List<BookForLoan> books = repoBooks.getAllBookForLoan();
	List<Member> members = repoMembers.getAllMember();
	List<LoanBookOrder> loanOrder = new ArrayList<LoanBookOrder>();
	
	MainMenu mainMenu = new MainMenu();
	mainMenu.mainMenu(books, members, loanOrder);
	System.out.println("Terimaksih");

	

    }

    
}
