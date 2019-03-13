package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import controlLayer.CustomerController;
import controlLayer.EmployeeController;
import controlLayer.ItemController;
import controlLayer.OrderController;
import modelLayer.Item;
import modelLayer.Order;
import modelLayer.OrderContainer;

public class OrderControllerTest {
	
	// *** Kør hver test for sig selv ***
	
	@Test
	public void testCreateOrder() {
		EmployeeController employeeController = new EmployeeController();

		employeeController.createEmployee("Jacob", "Revlevej", "90909090", "Høj@gmail.com", 9000, "Aalborg",
				"Medarbejder");

		OrderController orderController = new OrderController();

		OrderContainer orderContainer = OrderContainer.getInstance();

		orderController.createOrder(false, null, "90909090");
		
		assertEquals(1, orderContainer.getOrders().size());
		assertNotNull(orderContainer.getOrders());
	}

	@Test
	public void testAddItemToOrderAndCalculatePrice() {
		EmployeeController employeeController = new EmployeeController();
		CustomerController customerController = new CustomerController();
		
		employeeController.createEmployee("Jacob", "Revlevej", "90909090", "Høj@gmail.com", 9000, "Aalborg",
				"Medarbejder");
		customerController.createCustomer("Joan", "Govej", "12345678", "moj@gmail.com", 9020, "IngeBy");
		
		OrderController orderController = new OrderController();
		Order order = orderController.createOrder(true, "12345678", "90909090");

		ItemController itemController = new ItemController();
		Item boremaskine = itemController.createItem(90.5, "Boremaskine til at bore med", "Boremaskine", "9823", true, 100);
		Item tandpasta = itemController.createItem(15.67, "Tandpasta til at børste med", "Tandpasta", "9983", true, 100);
		
		itemController.addQuantityToItem(tandpasta, 10);
		itemController.addQuantityToItem(boremaskine, 10);
		
		orderController.addItemToOrder(order, tandpasta, 1);
		orderController.addItemToOrder(order, boremaskine, 2);
		
		assertEquals(109, itemController.findItemByName("Tandpasta").getQuantity());
		assertEquals(108, itemController.findItemByName("Boremaskine").getQuantity());
		
		assertEquals(196.67, order.getPriceOfOrder(), 2);
	}
}