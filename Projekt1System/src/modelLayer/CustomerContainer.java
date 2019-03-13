package modelLayer;

import java.util.ArrayList;

public class CustomerContainer {
	private static CustomerContainer instance;
	private ArrayList<Customer> customerList;
	private ArrayList<DiscountType> discountTypeList; 

	private CustomerContainer() {
		customerList = new ArrayList<>();
		setDiscountTypeList(new ArrayList<>()); 
	}

	public static CustomerContainer getInstance() {
		if (instance == null) {
			instance = new CustomerContainer();
		}
		return instance;
	}

	public ArrayList<Customer> getCustomerList() {
		return customerList;
	}

	public void addCustomer(Customer customer) {
		customerList.add(customer);
	}

	public Customer getCustomerByPhoneNumber(String phoneNumber) {
		Customer res = null;
		for (Customer element : customerList) {
			if (element.getPhoneNo().equals(phoneNumber) == true) {
				res = element;
			}
		}
		return res;
	}

	public ArrayList<DiscountType> getDiscountTypeList() {
		return discountTypeList;
	}

	public void setDiscountTypeList(ArrayList<DiscountType> discountTypeList) {
		this.discountTypeList = discountTypeList;
	}
	
	public void addDiscountType(DiscountType discountType) {
		discountTypeList.add(discountType);
	}

}
