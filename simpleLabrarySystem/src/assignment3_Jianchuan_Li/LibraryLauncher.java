/** 
* File name: [LibraryLauncher.java ]
* Author: [ Jianchuan Li, 040956867]
* Course: 20W_CST8284_300
* Assignment: [3]
* Date: [2020-04-20]
* Professor: [Haider Miraj]
* Purpose: [library management system]
* Class list: [LibraryLauncher, Library, BookLoan, Book, Customer, DateCreator]
*/
package assignment3_Jianchuan_Li;
import java.util.ArrayList;
/**
* main class.
* Create 20 books and 10 customer. Create 3 loans for 3 customers(1 book each customer);Create 1 loans for one customer with 2 books; Create 1 loans one customer with 3 books; Repeating displaying the menu and execute the opinion until quit
* @author Jianchuan Li 
* @version 1.0
* @see java.util.ArrayList

*/
public class LibraryLauncher {
	/**
	 * this is main method to create 20 books and 10 customers, borrow 3 books for 3 customers(one for each), borrow 2 books for one customer, borrow 3 books for one customer, then launch the menu with launch() method in class library
	 *@param args an array of command-line arguments for the application
	 */
	public static void main(String[] args) {
		//all books in the library
		ArrayList<Book> libBook= new ArrayList<Book>();
		//all customer in the library
		ArrayList<Customer> libCustomer= new ArrayList<Customer>();
		//all the book(being loaned), customer(who loaned books) and loan-date
		ArrayList<BookLoan> libBookLoan= new ArrayList<BookLoan>();
		DataCreator.createBook(libBook, 20);
		DataCreator.outputData(libBook);
		DataCreator.createCustomer(libCustomer, 20);
		DataCreator.outputData(libCustomer);
		//lib is a library built through libBook,libCustomer,libBookLoan
		Library lib=new Library(libBook,libCustomer,libBookLoan);
		//loop for 3 times
		for(int i=0;i<3;i++) {
			//book is book in library with id(i)
			Book book =new Book();
			book= lib.getLibBook().get(i);
			//book is loaned by customer with id(i) in 2020-02-18
			lib.borrow(lib.getLibCustomer().get(i), book, "2020-02-18");
			

		}
		//book2 is book in library with id(3)
		Book book2 =new Book();
		book2= lib.getLibBook().get(3);
		//book2 is loaned by customer with id(3) in 2020-03-31
		lib.borrow(lib.getLibCustomer().get(3), book2, "2020-03-31");
		
		Book book3 =new Book();
		book3= lib.getLibBook().get(4);
		
		lib.borrow(lib.getLibCustomer().get(3), book3, "2020-03-31");
		
		Book book4 =new Book();
		book4= lib.getLibBook().get(5);
		
		lib.borrow(lib.getLibCustomer().get(4), book4, "2020-04-18");
		
		Book book5 =new Book();
		book5= lib.getLibBook().get(6);
		
		lib.borrow(lib.getLibCustomer().get(4), book5, "2020-04-18");
		
		Book book6 =new Book();
		book6= lib.getLibBook().get(7);
		
		lib.borrow(lib.getLibCustomer().get(4), book6, "2020-04-18");
		// launch the menu 
		lib.launch();
	}

}
