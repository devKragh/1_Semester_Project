package controlLayer;

import modelLayer.Customer;
import modelLayer.Employee;
import modelLayer.Item;
import modelLayer.Order;
import modelLayer.OrderContainer;

public class OrderController {
	private OrderContainer orderContainer;
	private EmployeeController employeeController;
	private CustomerController customerController;
	private ItemController itemController;

	public OrderController() {
		orderContainer = OrderContainer.getInstance();
		employeeController = new EmployeeController();
		customerController = new CustomerController();
		itemController = new ItemController();
	}

	/**
	 * This method will create an order with an employee and if needed a customer on
	 * it.
	 * 
	 * @param hasCustomer
	 *            is a boolean, that control which constructor you want to use.
	 * @param phoneNumberC
	 *            is the phone number on the customer, so you can put a customer on
	 *            the order
	 * @param phoneNumberE
	 *            is the phone number on the employee, so you can put an employee on
	 *            the order
	 * @return order object
	 */
	public Order createOrder(boolean hasCustomer, String phoneNumberC, String phoneNumberE) {
		Order order = null;
		if (hasCustomer == true) {
			order = new Order(findCustomer(phoneNumberC), findEmployee(phoneNumberE));
		} else {
			order = new Order(findEmployee(phoneNumberE));
		}
		return order;
	}

	/**
	 * This method stores the order in the system
	 * 
	 * @param order
	 * @return the order you just saved, so you can see the information on it.
	 */
	public Order addOrderToContainer(Order order) {
		orderContainer.addOrder(order);
		return order;
	}

	/**
	 * This method lets you find an order by it's Id.
	 * 
	 * @param orderId
	 * @return order
	 */
	public Order findOrderById(int orderId) {
		Order res = orderContainer.getOrderById(orderId);
		return res;
	}

	/**
	 * This method takes the given phone number on an employee and send it further
	 * for a search.
	 * 
	 * @param phoneNumber
	 * @return an employee
	 */
	public Employee findEmployee(String phoneNumber) {
		Employee employee = employeeController.findEmployeeByPhoneNumber(phoneNumber);
		return employee;
	}

	/**
	 * This method takes the given phone number on a customer and send it further
	 * for a search.
	 * 
	 * @param phoneNumber
	 * @return a customer
	 */
	public Customer findCustomer(String phoneNumber) {
		Customer customer = customerController.findCustomerByPhoneNumber(phoneNumber);
		return customer;
	}

	/**
	 * This method takes an item and a quantity of that given item and removes it
	 * from stock, then adds the item and quantity to the order
	 * 
	 * @param order
	 *            is the order, that is being created
	 * @param item
	 *            is the prefound item
	 * @param quantity
	 *            is the amount of the given item
	 * @return order
	 */
	public Order addItemToOrder(Order order, Item item, int quantity) {
		Item res;
		res = itemController.removeQuantity(item, quantity);
		// Needs to return a value, that prompts a message instead of doing nothing,
		// when there is
		// not enough items in stock.
		if (res != null) {
			order.addOrderLineToOrder(res, quantity);
		}
		return order;
	}

	/**
	 * This method gets a new customerController, when it needs to create a new
	 * customer
	 * 
	 * @return
	 */
	public CustomerController getCustomerController() {
		return customerController;
	}

	/**
	 * This method gets a new itemController, when it needs to create a new item
	 * 
	 * @return
	 */
	public ItemController getItemController() {
		return itemController;
	}

}
