/** 
* File name: [Library.java ]
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
import java.util.Calendar;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
/** 
* Library class enable users to display menu,
* add/change/remove customer,add/remove book, borrow book,
* display customers,books,and due date.
* @version 1.0
* @author Jianchuan Li 
* @see java.util.ArrayList
* @see java.util.Calendar
* @see java.util.InputMismatchException
* @see java.util.Scanner
*/
public class Library {
	/**
     * collection of books owned by library
     * @see #Library(ArrayList, ArrayList, ArrayList)
     */
	private ArrayList<Book> libBook= new ArrayList<Book>();
	/**
     * collection of customers owned by library
     * @see #Library(ArrayList, ArrayList, ArrayList)
     */
	private ArrayList<Customer> libCustomer= new ArrayList<Customer>();
	/**
     * collection of books(being loaned), customers(who loaned books) and loan-date
     * @see #Library(ArrayList, ArrayList, ArrayList)
     */
	private ArrayList<BookLoan> libBookLoan= new ArrayList<BookLoan>();
	/**
     * current time as {@link #TODAY}.
     */
	public static final Calendar TODAY = Calendar.getInstance();
	/**
     * used in menu instead of number
     * The value of this constant is {@value}.
     */
	 private final int CHANGE_CUSTOMER=1;
	 /**
	  * used in menu instead of number
	  * The value of this constant is {@value}.
	  */
	 private final int CHANGE_BOOK=2;
	 /**
	  * used in menu instead of number
	  * The value of this constant is {@value}.
	  */
	 private final int LOAN_BOOK=3;
	 /**
	  * used in menu instead of number
	  * The value of this constant is {@value}.
	  */
	 private final int DISPLAY_CUSTOMERWITHLOAN=4;
	 /**
	  * used in menu instead of number
	  * The value of this constant is {@value}.
	  */
	 private final int DISPLAY_CUSTOMERWITHFINE=5;
	 /**
	  * used in menu instead of number
	  * The value of this constant is {@value}.
	  */
	 private final int DISPLAY_CHECKOUTBOOK=6;
	 /**
	  * used in menu instead of number
	  * The value of this constant is {@value}.
	  */
	 private final int DISPLAY_OVERDUELOAN=7;
	 /**
	  * used in menu instead of number
	  * The value of this constant is {@value}.
	  */
	 private final int EXIT=0;
	 Scanner input = new Scanner(System.in);
	 /**
	  * constructor of Library, 
	  * @param libBook collection of books 
	  * @param libCustomer	collection of customers 
	  * @param libBookLoan	collection of books(being loaned), customers(who loaned books) and loan-date
	  */
	public Library(ArrayList<Book> libBook,ArrayList<Customer> libCustomer,ArrayList<BookLoan> libBookLoan) {
		setLibBook(libBook);
		setLibCustomer(libCustomer);
		setLibBookLoan(libBookLoan);
	}
	/**
	 * gets  books owned by the library
	 * @return the ArrayList of books owned by the library
	 */
	public ArrayList<Book> getLibBook() {
		return libBook;
	}
	/**
	 * sets  books owned by the library
	 * @param libBook
	 * 		collection of books
	 */
	public void setLibBook(ArrayList<Book> libBook) {
		this.libBook=libBook;
		
	}
	/**
	 * gets customers owned by the library
	 * @return the ArrayList of customers owned by the library
	 */
	public ArrayList<Customer> getLibCustomer() {
		return libCustomer;
	}
	/**
	 * sets the customers owned by the library
	 * @param libCustomer collection of customers
	 */
	public void setLibCustomer(ArrayList<Customer> libCustomer) {
		this.libCustomer=libCustomer;
		
	}
	/**
	 * get the collection of books(being loaned), customers(who loaned books) and loan-date in the library
	 * @return the ArrayList of books,customers, and loan-dates
	 */
	public ArrayList<BookLoan> getLibBookLoan() {
		return libBookLoan;
	}
	/**
	 * set the books(being loaned), customers(who loaned books) and loan-date in the library
	 * @param libBookLoan collection of books,customers, and loan-dates
	 */
	public void setLibBookLoan(ArrayList<BookLoan> libBookLoan) {
		this.libBookLoan=libBookLoan;
		
	}
	 /**
	  * display global menu and perform user's choice
	  * @see #executeMenuItem(int)
	  * @see #displayMenu()
	  **/
	 
	 public void launch() {
		 
		 //choose is the user's choice which is returned by displayMenu()
		int choose=displayMenu();
		//loop the menu and execute the opinion until EXIT is choose
		while(choose!=EXIT) {
			
			executeMenuItem(choose);
			choose=displayMenu();
		 }
		System.out.println("Goodbye!");	 
		 
	 }
	 /**
	  * display menu,the constants is used instead of 1,2,3,4
	  * @return an integer as user's choice
	  * @exception InputMismatchException if user inputs anything except number
	  */
	 private int displayMenu() {
		 try{System.out.printf("%s%n%d%s%n%d%s%n%d%s%n%d%s%n%d%s%n%d%s%n%d%s%n%d%s%n","Enter a selection from the following menu:",CHANGE_CUSTOMER,". add/change/remove a customer",CHANGE_BOOK,". add/remove a book",LOAN_BOOK,". loan book(s)",DISPLAY_CUSTOMERWITHLOAN,". Display all customer who loaned books",DISPLAY_CUSTOMERWITHFINE,". Display all customer with fine",DISPLAY_CHECKOUTBOOK,". Display all checked books",DISPLAY_OVERDUELOAN,". Display all overdue loan",EXIT,". Exit program");
		 //choose if user's choice
		 int choose= input.nextInt();
		 
		 return choose;
		 }catch(InputMismatchException e) {
				System.out.println("Please input a number");
				return 0;
			}
	 }
	 /**
	  * execute the menu as user's choice
	  * 1 for chnage customer,2 for change book,3 for loan books, 4 for display all customers with loan, 5 for display all customer with fine, 6 for display all checked books,7 for display all overdue loan, 0 for exit.
	  * @see #changeCustomer()
	  * @see #changeBook()
	  * @see #borrow(Customer customer, Book book, String date)
	  * @see BookLoan#getFine()
	  * @see DataCreator#outputData(java.util.Collection)
	  * @param num user's choice
	  */
	 private void executeMenuItem(int num) {
		 //the constants is used instead of 1,2,3,4
		 switch(num) {
		 
		 case CHANGE_CUSTOMER:
			 changeCustomer();
			 break;
			 
		 case CHANGE_BOOK:
			 changeBook();
			 break;
		 
		 case LOAN_BOOK:
			 //cus would be the customer who wants to loan book
			 Customer cus=new Customer();
			 //b would be the book which would be loaned
			 Book b=new Book();
			 input.nextLine();
			 System.out.println("input Customer id");
			 //cid is the customer's id
			 int cid=input.nextInt();
			 input.nextLine();
			 
				 
				 System.out.println("input book id");
				 //bid is the book's id
				 int bid=input.nextInt();
				 input.nextLine();
				 //cover each book in library
				 for(Book book: getLibBook()) {
					 //find the book with the given id
					 if(book.getBookId()==bid) {
						 //assign b to the book with the given id
						 b= book;
					 }
				 
			 }
			 System.out.println("input date like yyyy-mm-dd");
			 //date would be the borrow date
			 String date=input.nextLine();
			//cover each customer in library
			 for(Customer customer: getLibCustomer()) {
				//find the customer with the given id
				 if(customer.getCustomerId()==cid) {
					//assign c to the customer with the given id
					 cus=customer;
				 }
			 }
			 
			 borrow(cus, b, date);

			 break;
		 
		 case DISPLAY_CUSTOMERWITHLOAN:
			
			DataCreator.outputData(getLibBookLoan());
			
			 break;
		 	 	
		 case DISPLAY_CUSTOMERWITHFINE:
			 //customer1 would be the customer with fine
			 //use HashSet to prevent duplicated customer
			 HashSet<Customer> customer1=new HashSet<>();
			 for(BookLoan bookloan:getLibBookLoan()) {
				 if(bookloan.getFine()>0) {
					 customer1.add(bookloan.getCustomer());
				 }
				 
			 }
			 DataCreator.outputData(customer1);
			 break;
		 case DISPLAY_CHECKOUTBOOK:
			 //book2 is the books loaned
			 //since a book is loaned once at the same time,ArrayList is enough
			 ArrayList<Book> book2=new ArrayList<>();
			 for(BookLoan bookloan:getLibBookLoan()) {
				 
					 book2.add(bookloan.getBook());
				 
				 
			 }
			 DataCreator.outputData(book2);
			 break;
		 case DISPLAY_OVERDUELOAN:
			 // bookloan2 is the BookLoan which only includes with overdue loan and correspondent books and customers
			 ArrayList<BookLoan> bookloan2=new ArrayList<>();
			 //loop cover each item in the library's BookLoan
			 for(BookLoan bookloan:getLibBookLoan()) {
				 // check whether the due date of the item is before today,if yes, this item is with overdue loan
				 if(bookloan.getDueDate().before(TODAY.getTime())) {
					 bookloan2.add(bookloan);
				 }
				 
			 }
			 DataCreator.outputData(bookloan2);	
		 default:
		 	break;		
		 }
		
	 }

	/**
	 * Display menu of changeCustomer, option include add customer,change address, and remove customer.Perform user's choice by call other methods following. If user input other character than number, display"Please input a number" and exit.
	 * @return boolean as the status
	 * @exception InputMismatchException if user inputs anything except number
	 */
	private boolean changeCustomer() {
		try{System.out.println("Select your choic : 1.add customer 2.change address 3.remove customer");
		// choose is user's input
		 int choose=input.nextInt();
		 input.nextLine();
		 	switch(choose){
		 	case 1:
		 		addCustomer();
		 		break;
		 	case 2:
		 		changeAddress();
		 		break;
		 	case 3:
		 		removeCustomer();
		 		break;
		 	default:
		 		return false;
		 	}
		 	return false;
		 	//if user's input is not number, InputMismatchException would be catched.
		}catch(InputMismatchException e) {
			System.out.println("Please input a number");
			return false;
		}
	}
	/** 
	 * add the customer if it is not customer of library now
	 * @return boolean as status(true for success, false for not success)
	 * @see Customer#equals(Customer)
	 */
	private boolean addCustomer() {
		System.out.println("Input the customer name");
		//name is customer's name
		String name=input.nextLine();
		System.out.println("Input the customer address");
		//address is customer's address
		String address=input.nextLine();
		//customer1 is a new customer with given name and address, the id is 0
		Customer customer1=new Customer(0,name,address);
		// a loop covering each customer of the library
		for (Customer customer : getLibCustomer()) {
			//if customer1 equals to one customer of the library
			if (customer.equals(customer1)){
				System.out.println("customer exits");
				return false;
			}
			
		}
		//customer1 is rebuilt through the id, given name, and address
		customer1=new Customer((getLibCustomer().get(getLibCustomer().size()-1)).getCustomerId()+1, name,address);
		//customer1 is added into the collection of library customers
		getLibCustomer().add(customer1);
		System.out.println("customer is added");
		return true;
		
		
	}
	/**
	 * change library customer address
	 * @return boolean as status(true for success, false for not success)
	 * @see Customer#equals(Customer)
	 */
	private boolean changeAddress() {
		System.out.println("Input the customer name needed to change");
		//name is customer's name
		String name=input.nextLine();
		System.out.println("Input the customer address needed to change");
		//address is customer's address
		String address=input.nextLine();
		//customer1 is a new customer with given name and address,the id is 0
		Customer customer1=new Customer(0,name,address);
		// a loop covering each customer of the library
		for (Customer customer : getLibCustomer()) {
			//if customer1 equals to one customer of the library
			if (customer.equals(customer1)){
				System.out.println("Input the new address");
				//change customer's address
				customer.setAddress(input.nextLine());
				System.out.println("address changed");
				return true;
			}
		}
		System.out.println("customer doesn't exit");
		return false;
		
	}
	/**
	 * remove the library customer if it didn't loan books 
	 * @return boolean as status(true for success, false for not success)
	 * @see #checkLoanBook(Customer)
	 * @see Customer#equals(Customer)
	 */
	private boolean removeCustomer() {
		System.out.println("Input the customer name needed to remove");
		//name is customer's name
		String name=input.nextLine();
		System.out.println("Input the customer address needed to remove");
		//address is customer's address
		String address=input.nextLine();
		//customer1 is a new customer with given name and address,the id is 0
		Customer customer1=new Customer(0,name,address);
		// a loop covering each customer of the library
		for (Customer customer : getLibCustomer()) {
			//if customer1 is a customer of the library and has no loan,remove customer and return true
			if (customer.equals(customer1) && !checkLoanBook(customer1)){
				getLibCustomer().remove(customer);
				System.out.println("customer is removed");
				return true;
			//if customer has loan,return false
			}else if(checkLoanBook(customer1)) {
				System.out.println("customer can't be removed due to loaned book.");
				return false;
			}
		}
		System.out.println("customer doesn't exit");
		return false;
		
	}
	/**
	 * display menu and perform user's choice return status
	 * @return user's choice
	 * @see #addBook()
	 * @see #removeBook()
	 * @exception InputMismatchException if user inputs anything except number
	 */
	private boolean changeBook() {
		try{System.out.println("Select your choic : 1.add book 2.remove book");
		 int choose=input.nextInt();
		 input.nextLine();
		 	switch(choose){
		 	case 1:
		 		addBook();
		 		break;
		 		

		 	case 2:
		 		removeBook();
		 		break;
		 	default:
		 		return false;
		 		
		 	}
		 	return false;
		}catch(InputMismatchException e) {
			System.out.println("Please input a number");
			return false;
		}
	}
	/**
	 * add the book to library's books collection
	 * @return boolean as status(true for success, false for not success)
	 */
	private boolean addBook() {
		System.out.println("Input the book name");
		//name is book title
		String name=input.nextLine();
		System.out.println("Input the book author");
		//author is book's author
		String author=input.nextLine();
		//book1 is a new book with id 0, given title and author
		Book book1= new Book(0,name,author);
		// a loop covers each book in the library
		for (Book book : getLibBook()) {
			// check whether book1 equals a book in the library, if is,return false,if not add book1 to library book collection and return true
			if (book.equals(book1)){
				System.out.println("book exits");
				return false;
			}
			
		}
		//book1'id change to new id.
		book1.setBookId((getLibBook().get(getLibBook().size()-1)).getBookId()+1);
		getLibBook().add(book1);
		System.out.println("book is added");
		return true;
		
		
	}
	/**
	 *  remove one book from the library if it is not loaned and return true, otherwise, return false
	 * @return  boolean as status(true for success, false for not success)
	 */
	private boolean removeBook() {
		System.out.println("Input the book name needed to remove");
		//name is book title
		String name=input.nextLine();
		System.out.println("Input the book author needed to remove");
		//author is book's author
		String author=input.nextLine();
		//book1 is a new book with id 0, given title and author
		Book book1= new Book(0,name,author);
		// a loop covers each book in the library
		for (Book book : getLibBook()) {
			// check whether book1 equals a book in the library and whether it isn't loaned.If not removed book1 from library and return true. If not,return false
			if (book.equals(book1) &&!checkLoanBook(book1)){
				getLibBook().remove(book);
				System.out.println("book is removed");
				return true;
			}
		}
		System.out.println("book doesn't exit");
		return false;
	
	}
	/**
	 * check whether book is loaned
	 * @param book book to be checked
	 * @return  boolean as status(true for success, false for not success)
	 * @see Book#equals(Book)
	 */
	private boolean checkLoanBook(Book book) {
		//loop cover each item in the collection of loaned book, customer who loaned and loan-date
		for (BookLoan bookloan : getLibBookLoan()) {
			//If book equals to one book in the collection, return true. if not, return false
			if (bookloan.getBook().equals(book)){
				
				return true;
			}
		
		}
		return false;
	}
	/**
	 *  check whether customer has loaned book
	 * @param customer customer to be checked
	 * @return boolean as status(true for success, false for not success)
	 * @see Customer#equals(Customer)
	 */
	private boolean checkLoanBook(Customer customer) {
		//loop cover each item in the collection of loaned book, customer who loaned and loan-date
		for (BookLoan bookloan : getLibBookLoan()) {
			//If customer equals to one customer in the collection, return true. if not, return false
			if (bookloan.getCustomer().equals(customer)){
					
				return true;
			}
			
		}
		return false;
	}
	
	/**
	 * create loan
	 * @param customer customer who would loan book
	 * @param book book which would be loaned
	 * @param date the loan date
	 * @return boolean as status(true for success, false for not success)
	 * @see Book#equals(Book)
	 * @see Customer#equals(Customer)
	 */
	public boolean borrow(Customer customer, Book book, String date) {
		// bookNum is the numbers of books which the customer loaned
		int bookNum=0;
		//loop cover each item in the collection of loaned book, customer who loaned and loan-date
		for (BookLoan bookloan : getLibBookLoan()) {
			//if book exits in bookloan, display "book is loaned",return false
			
				if(book.equals(bookloan.getBook())){
					System.out.println("book is loaned");
					return false;
				}
			
			// if customer is library's customer and hasn't overdue book, check how many books the customer loaned
			// if customer is library's customer
			if(customer.equals(bookloan.getCustomer())) {
				//if customer hasn't overdue book
				if(bookloan.getFine()>0) {
					System.out.println("You have overdued book,please return it and pay the fine");
					return false;
				}else {
					bookNum++;	
				}
					
				
			}
			
		}
		//if books the customer loaned are less than 3,borrow this book and return true, else, return false
		if((1+bookNum)<=3){
			
				BookLoan bookloan1=new BookLoan(customer,book,date);
				getLibBookLoan().add(bookloan1);
				System.out.println("Great! "+ customer.getCustomerId()+" "+customer.getName()+" loan " + book.getBookId()+"  "+ book.getTitle());
			return true;
		}else {
				System.out.println("You can't loan more three books");
				return false;
		
		
		}
	}
	
}
