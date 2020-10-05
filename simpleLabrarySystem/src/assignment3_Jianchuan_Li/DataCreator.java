/** 
* File name: [DataCreator.java ]
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
import java.util.Collection;
/** 
* This class include static methods to create arrayList book and customer automatically or display customer,book,due date information.
* @see java.util.ArrayList
* @see java.util.Collection
* @version 1.0
* @author Jianchuan Li
*/


public class DataCreator {
	/**
	* display the items in a list
	* @param l collection of element
	* @param <E> item type in collection
	*/
	public static <E> void outputData(Collection<E> l ) {
		//loop cover each item in list l
		for (E element : l) {
			System.out.println(element);
		}
	}
	/**
	 * create num books 
	 * @param b collection of book
	 * @param num number of books
	 */
	public static void createBook(ArrayList<Book> b , int num ) {
		//loop num times
		for(int i=0; i < num; i++) {
			// bufferTitle is collection of character which is used to build a book title
		    StringBuilder bufferTitle = new StringBuilder();
		 // bufferTitle is collection of character which is used to build a book author
		    StringBuilder bufferAuthor = new StringBuilder();
		    //loop 6 times
		    for (int k = 0; k < 6; k++) {
		    	// title is character ACSI number for title,"97 + (int)(Math.random() * 26)" is expression to create character in a-z
		        int title = 97 + (int)(Math.random() * 26);
		        // put the character into title
		        bufferTitle.append((char)title);
		     // author is character ACSI number for author,"97 + (int)(Math.random() * 26)" is expression to create character in a-z
		        int author = 97 + (int)(Math.random() * 26);
		     // put the character into author
		        bufferAuthor.append((char)author);
		    }
		    //generatedTitle is book title in String format transfered from bufferTitle
		    String generatedTitle = bufferTitle.toString();
		    //generatedAuthor is book author in String format transfered from bufferAuthor
		    String generatedAuthor = bufferAuthor.toString();
		    //book is a book built through id(i),generatedTitle,generatedAuthor
			Book book=new Book(i,generatedTitle,generatedAuthor );
			// book is added to books collection
			b.add(book);
		}
	}
	/**
	 * create num customers 
	 * @param c collection of customers
	 * @param num number of customers
	 */
	public static void createCustomer(ArrayList<Customer> c , int num ) {
		//loop num times
		for(int i=0; i < num; i++) {
			// bufferName is collection of character which is used to build a customer name
		    StringBuilder bufferName = new StringBuilder();
		 // bufferAddress is collection of character which is used to build a customer address
		    StringBuilder bufferAdress = new StringBuilder();
		  //loop 6 times
		    for (int k = 0; k < 6; k++) {
		    	//name is character ACSI number for name,"97 + (int)(Math.random() * 26)" is expression to create random character in a-z
		        int name = 97 + (int)(Math.random() * 26);
		        bufferName.append((char)name);
		      //name is character ACSI number for name,"97 + (int)(Math.random() * 26)" is expression to create random character in a-z
		        int adress = 97 + (int)(Math.random() * 26);
		        bufferAdress.append((char)adress);
		    }
		  //generatedName is customer name in String format transfered from bufferName
		    String generatedName = bufferName.toString();
		  //generatedAdress is customer name in String format transfered from bufferAdress
		    String generatedAdress = bufferAdress.toString();
		  //customer is a customer built through id(i),generatedName,generatedAdress
			Customer customer=new Customer(i,generatedName,generatedAdress );
			c.add(customer);
		}
	}
	
}
