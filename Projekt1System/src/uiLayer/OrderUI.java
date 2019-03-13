package uiLayer;

import controlLayer.OrderController;
import modelLayer.Item;
import modelLayer.Order;
import modelLayer.OrderLine;
import uiLibary.*;

public class OrderUI {

	private OrderController orderController;
	private ITextInput textInput;

	public OrderUI() {
		orderController = new OrderController();
		textInput = new TextInput();
	}

	/**
	 * Prints main menu for the Order UI, where you can either create a new Order or
	 * find an old.
	 */
	public void printMainOrderMenu() {
		boolean running = true;
		while (running) {
			int choice;

			System.out.println("*** Order Menu ***\n" + "Please select an option.");
			System.out.println("[1] Create Order.");
			System.out.println("[2] Find order to view information about an order.");
			System.out.println("[0] Cancel.");

			choice = textInput.promptIntBetween("Input valid choice", "That is not a valid input", 0, 2);
			switch (choice) {
			case 1:
				printCreateOrderMenu();
				break;
			case 2:
				printFindOrderMenu();
			case 0:
				running = false;
				break;
			default:
				break;
			}
		}
	}

	/**
	 * Prints the Create Order menu, where you can either do it with or without a
	 * customer.
	 */
	private void printCreateOrderMenu() {

		int choice;

		String customerPhone;
		String employeePhone;
		Order order = null;

		System.out.println("[1] Create Order with a Customer.");
		System.out.println("[2] Create Order without a Customer.");
		System.out.println("[0] Cancel.");

		choice = textInput.promptIntBetween("Input valid choice", "That is not a valid input", 0, 2);
		employeePhone = textInput.promptString("Please input Employee Phone No.");

		switch (choice) {
		case 1:
			customerPhone = textInput.promptString("Please input Customer Phone No.");

			if (orderController.findCustomer(customerPhone) == null) {
				customerPhone = createCustomer();
			}
			order = orderController.createOrder(true, customerPhone, employeePhone);
			break;
		case 2:
			order = orderController.createOrder(false, null, employeePhone);
			break;
		case 0:
			break;
		default:
			break;
		}
		addItemToOrder(order);
	}

	/**
	 * Takes the order you have begun creating, then searches for a product/item and
	 * add it to the given order. Repeats until you don't want more on the order. At
	 * the end it saves the order.
	 * 
	 * @param order
	 */
	private void addItemToOrder(Order order) {
		boolean running = true;
		int choice2;
		Item item;

		while (running) {
			System.out.println("Do you want to add a Product?");
			System.out.println("[1] Yes.");
			System.out.println("[2] No, continue.");
			choice2 = textInput.promptIntBetween("", "That is not a valid input", 1, 2);

			switch (choice2) {
			case 1:
				String name = textInput.promptString("Input a Name on a Product.");
				item = orderController.getItemController().findItemByName(name);
				if (item != null) {
					int quantity = textInput.promptInt("Input quantity of the chosen Product", "Input a valid number");
					if (item.getQuantity() >= quantity) {
						orderController.addItemToOrder(order, item, quantity);
					} else {
						System.out.println("There are only " + item.getQuantity() + " " + item.getName() + " left");
					}
				} else {
					System.out.println("Couldn't find that item.");
				}
				break;
			case 2:
				running = false;
				break;
			}
		}
		orderController.addOrderToContainer(order);
		printOrderInformation(order);

	}

	/**
	 * If you wanted an Order with a customer, but customer wasn't in the system,
	 * then this method will take the information and send the information to
	 * creation of a new customer.
	 * 
	 * @return a String with the Customer information
	 */
	private String createCustomer() {
		String name = textInput.promptString("Input Customer Name: ");
		String address = textInput.promptString("Input Customer address: ");
		String phoneNo = textInput.promptString("Input Customer PhoneNo: ");
		String mail = textInput.promptString("Input Customer Mail: ");
		int postalCode = textInput.promptInt("Input Customer PostalCode: ",
				"Please input a valid Postal Code in numbers.");
		String city = textInput.promptString("Input Customer City: ");
		orderController.getCustomerController().createCustomer(name, address, phoneNo, mail, postalCode, city);
		return phoneNo;
	}

	/**
	 * This method will print the menu for finding an order, by either searching for
	 * a single order or list every order in the system
	 */
	private void printFindOrderMenu() {
		Order order;
		int orderId;

		System.out.println("[1] Find order by ID.");
		System.out.println("[2] List all orders.");
		System.out.println("[0] Cancel.");

		int choice = textInput.promptIntBetween("Input a valid choice.", "That is not a valid choice.", 0, 2);
		switch (choice) {
		case 1:
			orderId = textInput.promptInt("Please input order ID", "Order ID has to be a number");
			order = orderController.findOrderById(orderId);
			if (order != null) {
				printOrderInformation(order);
			} else {
				System.out.println("Order could not be found.");
			}
			break;
		case 2:
			System.out.println("This feature has not yet been implemnted");
			break;
		case 0:
			break;
		default:
			break;

		}
	}

	/**
	 * When you have found a given order, this method will print the information it
	 * has including the products/items it have on it.
	 * 
	 * @param order
	 */
	private void printOrderInformation(Order order) {
		System.out.println("Order ID: " + order.getOrderId());
		if (order.getCustomer() != null) {
			System.out.println("Custormer name: " + order.getCustomer().getName() + "\nCustormer phone: "
					+ order.getCustomer().getPhoneNo());
		} else {
			System.out.println("No customer applied to this order.");
		}
		System.out.println("***Products on order***");
		for (OrderLine element : order.getOrderLines()) {
			System.out.println(element.getItem().getName() + " " + element.getItem().getPrice() + " x "
					+ element.getQuantityOfItems() + " = " + element.getPriceOfOrderLine());
		}
		System.out.println("************************");
		System.out.println("Sum of order			" + order.getPriceOfOrder());
		System.out.println("You were served by: " + order.getEmployee().getName());
		printFindOrderMenu();
	}
}
