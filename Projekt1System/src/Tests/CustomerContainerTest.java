package Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controlLayer.CustomerController;
import modelLayer.Customer;
import modelLayer.CustomerContainer;

public class CustomerContainerTest {

	CustomerContainer customerContainer;
	Customer customer1;
	Customer customer2;
	CustomerController customerController;
	ArrayList<Customer> customerList;

	@Before
	public void setUp() {
		customerContainer = CustomerContainer.getInstance();
		customerController = new CustomerController();
		customerList = customerContainer.getCustomerList();
		
		customer1 = customerController.createCustomer("Jacob", "Ribevej", "02924122", "Proton", 9200, "Aalborg SV");
		customer2 = customerController.createCustomer("Kaj", "Revlevej", "22421522", "Gmail", 9200, "Aalborg SV");
	}

	@Test
	public void testCustomerListIsNotNull() {
		assertNotNull(customerList);
	}
	
	@After
	public void tearDown() {
		customerContainer.getCustomerList().remove(customer1);
		customerContainer.getCustomerList().remove(customer2);
	}

}
