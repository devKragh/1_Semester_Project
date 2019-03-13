package uiLayer;

import uiLibary.*;

import controlLayer.CustomerController;
import modelLayer.Customer;

public class CustomerUI {
	private CustomerController customerController;
	private ITextInput textInput;

	public CustomerUI() {
		customerController = new CustomerController();
		textInput = new TextInput();
	}

	/**
	 * This method prints the main customer menu, where you can create a new
	 * customer or find an existing customer.
	 */
	public void printMainCustomerMenu() {
		boolean running = true;
		while (running) {
			int choice;

			System.out.println("*** Customer Menu ***\n" + "Please select an option.");
			System.out.println("[1] Create a Customer.");
			System.out.println("[2] Find a Customer to update information or set activity status.");
			System.out.println("[0] Cancel.");

			choice = textInput.promptIntBetween("Input choice.", "Invalid input. Must contain numbers.", 0, 2);

			switch (choice) {
			case 1:
				printCreateCustomerMenu();
				break;
			case 2:
				printFindCustomerMenu();
				break;
			case 0:
				running = false;
				break;
			default:
				break;
			}
		}
	}

	/**
	 * This method prompts the parameters needed to create a new customer and send
	 * the information to the controller.
	 */
	private void printCreateCustomerMenu() {
		System.out.println("Please input information in the requested order to create a Customer");

		String name = textInput.promptString("Input Name.");
		String address = textInput.promptString("Input Address.");
		String phoneNo = inputPhoneNumber();
		String mail = textInput.promptString("Input E-Mail.");
		int postalCode = inputPostalCode();
		String city = textInput.promptString("Input City.");

		customerController.createCustomer(name, address, phoneNo, mail, postalCode, city);

		System.out.println("Created " + name + ".");
	}

	/**
	 * This method lets you find a customer on their phone number, then prompts the
	 * choices to either update or change their active status.
	 */
	private void printFindCustomerMenu() {
		String input;
		int choice;
		Customer customer;

		input = textInput.promptString("Input Phone Number.");

		customer = customerController.findCustomerByPhoneNumber(input);

		if (customer != null) {

			printCustomerInformation(customer);

			System.out.println("What would you like to do with this Customer.");

			System.out.println("[1] Update Customer Information.\n" + "[2] Change active status of the Customer.\n"
					+ "[0] Cancel.");

			choice = textInput.promptIntBetween("Input valid option.", "Not valid input, try again.", 0, 2);

			switch (choice) {
			case 1:
				printUpdateCustomerMenu(customer);
				break;
			case 2:
				setActivity(customer);
				break;
			case 0:
				printMainCustomerMenu();
				break;
			default:
				break;
			}
		} else {
			System.out.println("Customer not found. Try again.");
			printFindCustomerMenu();
		}
	}

	/**
	 * This method prompts the parameters you can update on the given customer
	 * 
	 * @param customer
	 */
	private void printUpdateCustomerMenu(Customer customer) {

		System.out.println("To Update a Customer's information, please input valid information when requested.");

		String name = textInput.promptString("Input Name.");
		String address = textInput.promptString("Input Address.");
		String phoneNo = inputPhoneNumber();
		String mail = textInput.promptString("Input E-Mail.");
		int postalCode = inputPostalCode();
		String city = textInput.promptString("Input City.");

		customerController.updateCustomer(customer, name, address, phoneNo, mail, postalCode, city);

		System.out.println("Updated " + customerController.getName(customer) + ".");

		printMainCustomerMenu();
	}

	/**
	 * This method prints the information on the given customer.
	 * 
	 * @param customer
	 */
	private void printCustomerInformation(Customer customer) {
		System.out.println("Name: " + customerController.getName(customer));
		System.out.println("Address: " + customerController.getAddress(customer));
		System.out.println("Phone Number: " + customerController.getPhoneNo(customer));
		System.out.println("Mail: " + customerController.getMail(customer));
		System.out.println("Postal Code: " + customerController.getPostalCode(customer));
		System.out.println("City: " + customerController.getCity(customer));
	}

	/**
	 * This method lets you set the active status on an customer and prints their
	 * new status.
	 * 
	 * @param customer
	 */
	private void setActivity(Customer customer) {

		customerController.setActivity(customer);

		System.out.println(customerController.getName(customer) + " had his/her status changed to: "
				+ customerController.isActive(customer));
	}

	/**
	 * This method checks that your phone number input is exactly 8 characters long.
	 * 
	 * @return
	 */
	private String inputPhoneNumber() {

		String phoneNumber = textInput.promptString("Input Phone Number. Must be 8 characters long.");

		if (phoneNumber.length() < 8 && phoneNumber.length() > 8) {
			System.out.println("Input is not 8 characters long. Try again.");
			inputPhoneNumber();
		}
		return phoneNumber;
	}

	/**
	 * This method checks that your postal code input is exactly 4 characters long.
	 * 
	 * @return
	 */
	private int inputPostalCode() {

		int postalCode = textInput.promptIntBetween("Input Postal Code.",
				"Postal Code must only contain numbers, be 4 characters long and be between 1000 and 9999.", 1000,
				9999);

		return postalCode;
	}
}
