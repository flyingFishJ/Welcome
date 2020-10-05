/** 
* File name: [Book.java ]
* Author: [ Jianchuan Li, 040956867]
* Course: 20W_CST8284_300
* Assignment: [3]
* Date: [2020-04-20]
* Professor: [Haider Miraj]
* Purpose: [library management system]
* Class list: [LibraryLauncher, Library, BookLoan, Book, Customer, DateCreator]
*/
package assignment3_Jianchuan_Li;
/** 
* This class include constructor, general methods, including getters,setters, toString(),equals().
* @version 1.0
* @author Jianchuan Li 
*/


public class Book{
	/**
     * id is the book's id
     * @see #Book(int, String, String)
     */
	private int id;
	/**
     * title is the book's title
     * @see #Book(int, String, String)
     */
	private String title;
	/**
     * author is the book's author
     * @see #Book(int, String, String)
     */
	private String author;
	/**
	 * no args constructor of Book, chained to one with arguments.
	 * @see #Book(int, String, String)
	 */
	public Book() {
		this(0,"title","author");
	}
	/**
	 * constructor of Book
	 * @param id id of book
	 * @param title title of book
	 * @param author author of book
	 */
	public Book(int id, String title, String author) {
		setBookId(id);
		setTitle(title);
		setAuthor(author);
	}
	/**
	 * get the book author
	 * @return String book author
	 */
	public int getBookId() {
		return id;
	}
	/**
	 * set the book id
	 * @param id book id
	 */
	public void setBookId(int id) {
		this.id=id;
	}
	/**
	 * get the book author
	 * @return String book author
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * set the book title
	 * @param title book title
	 */
	public void setTitle(String title) {
		this.title=title;
	}
	/**
	 * get the book author
	 * @return String book author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * set the book author
	 * @param author book author
	 */
	public void setAuthor(String author) {
		this.author=author;
	}
	/**
	 * check whether two books are equal
	 * @param book book would be checked
	 * @return boolean as status(true for success, false for not success)
	 */
	public boolean equals(Book book) {
		//if book's title and book's author equals, two books are equal.
		if (book.getTitle().equals(getTitle()) && book.getAuthor().equals(getAuthor())){
			return true;
		}
		return false;
	}
	/**
	 *rewrite toString() method
	 *@return String with information demanded
	 */
	@Override
	public String toString() {
		return "Book title: " + getTitle();
	}
}
