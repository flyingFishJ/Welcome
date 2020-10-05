/** 
* File name: [BookLoan.java ]
* Author: [ Jianchuan Li, 040956867]
* Course: 20W_CST8284_300
* Assignment: [3]
* Date: [2020-04-20]
* Professor: [Haider Miraj]
* Purpose: [library management system]
* Class list: [LibraryLauncher, Library, BookLoan, Book, Customer, DateCreator]
*/
package assignment3_Jianchuan_Li;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
/** 
* This class include constructor, general methods, including getters,setters, toString().
* @version 1.0
* @author Jianchuan Li
* @see java.text.DateFormat
* @see java.text.ParseException
* @see java.text.SimpleDateFormat
* @see java.util.Calendar
* @see java.util.Date
* @see java.util.GregorianCalendar
*/
public class BookLoan {
	/**
     * book which is loaned 
     * @see #BookLoan(Customer, Book, String)
     */	
	private Book book;
	/**
     * customer who loaned books
     * @see #BookLoan(Customer, Book, String)
     */	
	private Customer customer;
	/**
     * the date the book should be returned before 
     * @see #BookLoan(Customer, Book, String)
     */	
	private Date dueDate;
	/**
     * the fine for the customer due to late returning
     */	
	private double fine;

	/**
     * the format to date
     */	
	private DateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
	/**
	 * constructor of BookLoan
 	 *@param customer customer who loaned books
 	 *@param book book which is loaned by customer
 	 *@param date date in which the book is loaned
 	 */
	public BookLoan(Customer customer, Book book,  String date) {
		setBook(book);
		setCustomer(customer);
		setDueDate(date);
	}
	/**
	 * get the book
	 * @return Book book is loaned
	 */
	public Book getBook() {
		return book;
	}
	/**
	 * set the book
	 * @param book book is loaned
	 */
	public void setBook(Book book) {
		this.book=book;
	}
	/**
	 * get the customer
	 * @return customer who loaned the book
	 */
	public Customer getCustomer() {
		return customer;
	}
	/**
	 * set the customer
	 * @param customer customer who loaned the book
	 */
	public void setCustomer(Customer customer) {
		this.customer=customer;
	}
	/**
	 * get the due day
	 * @return the date before which the book should be returned
	 */
	public Date getDueDate() {
		return dueDate;
	}
	/**
	 * set the due day
	 * @param date date is the day in which customer loaned the book
	 */
	public void setDueDate(String date) {
		
		try {
			//dt1 is the Date format transfered from String date which is the day in which customer loaned the book 
			Date dt1 = dateFormat.parse(date);
			//cal is a new GregorianCalendar() object
			GregorianCalendar cal  =  new GregorianCalendar();
			cal.setTime(dt1);
			//dueDate is 3 weeks later the input date
			cal.add(Calendar.WEEK_OF_YEAR, 3);
			this.dueDate=cal.getTime();
			setFine();
		} catch (ParseException e) {
			System.out.println("Please enter date like yyyy-MM-dd!");
		}
		
	}
	/**
	 * get the due fine
	 * @return the fine the customer should pay
	 */
	public double getFine() {
		return fine;
	}
	/**
	 * set fine to 0 when customer pay the fine
	 */
	public void setFine() {
		// now is the date of today
		Date now=new Date();
		if((now.getTime()-dueDate.getTime())>0) {
			this.fine=(now.getTime()-dueDate.getTime())/ (1000*60*60*24);
		}else {
			this.fine=0;
		}
		
	}
	/**
	 *rewrite toString() method
	 *@return String with information demanded
	 */
	@Override
	public String toString() {
		return String.format("%s\t%s\t%s%s\t%s%.2f", getCustomer().toString(),getBook().toString(),"Due date: ", dateFormat.format(getDueDate()),"Fine: $",getFine());
	}
}
