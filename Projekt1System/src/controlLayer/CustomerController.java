package controlLayer;

import modelLayer.Customer;
import modelLayer.CustomerContainer;
import modelLayer.DiscountType;

public class CustomerController {
	private DiscountType discountType;
	private CustomerContainer customerContainer;

	public CustomerController() {
		customerContainer = CustomerContainer.getInstance();
	}

	/**
	 * This method takes the given parameters and creates a customer object and adds
	 * it to the container.
	 * 
	 * @param name
	 * @param address
	 * @param phoneNo
	 * @param mail
	 * @param postalCode
	 * @param city
	 * @return
	 */
	public Customer createCustomer(String name, String address, String phoneNo, String mail, int postalCode,
			String city) {
		Customer customer = new Customer(name, address, phoneNo, mail, postalCode, city);
		customerContainer.addCustomer(customer);
		return customer;
	}

	/**
	 * This method lets you create a new discountType with a name and amount, but at
	 * the moment DiscountType has no effect on the system.
	 * 
	 * @param name
	 * @param discountAmount
	 * @return DiscountType
	 */
	public DiscountType createDiscountType(String name, double discountAmount) {
		discountType = new DiscountType(name, discountAmount);
		customerContainer.addDiscountType(discountType);
		return discountType;
	}

	/**
	 * This method updates the parameters on a given discountType, but is not yet
	 * implemented correctly in the system
	 * 
	 * @param name
	 * @param discountAmount
	 */
	public void updateDiscountType(String name, double discountAmount) {
		discountType.setName(name);
		discountType.setDiscountAmount(discountAmount);
	}

	/**
	 * This method gets a customer and some new data, then set the parameters on the
	 * object to the new information
	 * 
	 * @param customer
	 * @param name
	 * @param address
	 * @param phoneNo
	 * @param mail
	 * @param postalCode
	 * @param city
	 */
	public void updateCustomer(Customer customer, String name, String address, String phoneNo, String mail,
			int postalCode, String city) {
		customer.setName(name);
		customer.setAddress(address);
		customer.setPhoneNo(phoneNo);
		customer.setMail(mail);
		customer.setPostalCode(postalCode);
		customer.setCity(city);
	}

	/**
	 * This method gets a customer and switches active attribute, to set the
	 * employee as either active or not active in the system.
	 * 
	 * @param customer
	 */
	public void setActivity(Customer customer) {
		if (customer.isActive() == true) {
			customer.setActive(false);
		} else {
			customer.setActive(true);
		}
	}

	/**
	 * This method gets a phone number and searches for the customer by that phone
	 * number
	 * 
	 * @param phoneNumber
	 * @return
	 */
	public Customer findCustomerByPhoneNumber(String phoneNumber) {
		return customerContainer.getCustomerByPhoneNumber(phoneNumber);
	}

	public String getName(Customer customer) {
		return customer.getName();
	}

	public boolean isActive(Customer customer) {
		return customer.isActive();
	}

	public String getAddress(Customer customer) {
		return customer.getAddress();
	}

	public String getCity(Customer customer) {
		return customer.getCity();
	}

	public int getPostalCode(Customer customer) {
		return customer.getPostalCode();
	}

	public boolean getCredit(Customer customer) {
		return customer.getCredit();
	}

	public String getPhoneNo(Customer customer) {
		return customer.getPhoneNo();
	}

	public String getMail(Customer customer) {
		return customer.getMail();
	}
}
