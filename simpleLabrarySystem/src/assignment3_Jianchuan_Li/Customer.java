/** 
* File name: [Customer.java ]
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
* @author Jianchuan Li JAVA_8284
* 2020 Apr 19
*/
public class Customer {
	/**
     * id is the customer's id 
     * @see #Customer(int, String, String)
     */	
	private int id;
	/**
     * name is the customer's name 
     * @see #Customer(int, String, String)
     */	
	private String name;
	/**
     * address is the customer's address
     * @see #Customer(int, String, String)
     */	
	private String address;
	/**
	 * no args constructor of Customer, chained to param one.
	 * @see #Customer(int, String, String)
	 */
	public Customer() {
		this(0,"name","address");
	}
	/**
	 * constructor of Customer
	 * @param id id of customer
	 * @param name name of customer
	 * @param address address of customer
	 */
	public Customer(int id, String name, String address) {
		setCustomerId(id);
		setName(name);
		setAddress(address);
	}
	/**
	 * get the customer's id
	 * @return integer customer's id
	 */
	public int getCustomerId() {
		return id;
	}
	/**
	 * set customer's id
	 * @param id customer id
	 */
	public void setCustomerId(int id) {
		this.id=id;
	}
	/**
	 * get the customer's name
	 * @return integer customer name
	 */
	public String getName() {
		return name;
	}
	/**
	 * set the customer's name
	 * @param name customer's name
	 */
	public void setName(String name) {
		this.name=name;
	}
	/**
	 * get the customer's address
	 * @return String customer's address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * set the customer's address
	 * @param address customer's address
	 */
	public void setAddress(String address) {
		this.address=address;
	}
	/**
	 * check whether two customers are equal
	 * @param customer customer would be checked
	 * @return boolean as status(true for success, false for not success)
	 */
	public boolean equals(Customer customer) {
		//if customer's name and customer's address equals, two customers are equal.
		if (customer.getName().equals(getName()) && customer.getAddress().equals(getAddress())){
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
		return "Customer id: " + getCustomerId() + "\t\tCustomer name: " + getName() + "\t\tCustomer address: " + getAddress();
	}
}
