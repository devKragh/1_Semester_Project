package uiLayer;

import controlLayer.EmployeeController;
import modelLayer.Employee;
import uiLibary.ITextInput;
import uiLibary.TextInput;

public class EmployeeUI {
	private EmployeeController employeeController;
	private ITextInput textInput;

	public EmployeeUI() {
		employeeController = new EmployeeController();
		textInput = new TextInput();
	}

	/**
	 * This method prints the main employee menu, where you can create a new
	 * employee or find an existing.
	 */
	public void printMainEmployeeMenu() {
		boolean running = true;
		while (running) {
			int choice;

			System.out.println("*** Employee Menu ***\n" + "Please select an option.");
			System.out.println("[1] Create an Employee.");
			System.out.println("[2] Find an Employee to update information or set active status.");
			System.out.println("[0] Cancel.");

			choice = textInput.promptIntBetween("Input choice.", "Invalid input.", 0, 2);

			switch (choice) {
			case 1:
				printCreateEmployeeMenu();
				break;
			case 2:
				printFindEmployeeMenu();
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
	 * This method prompts the parameters needed to create a new Employee and send
	 * the information to the controller.
	 */
	private void printCreateEmployeeMenu() {
		System.out.println("Please input information in the requested order to create an Employee.");

		String name = textInput.promptString("Input Name.");
		String address = textInput.promptString("Input Address.");
		String phoneNo = inputPhoneNumber();
		String mail = textInput.promptString("Input E-Mail.");
		int postalCode = inputPostalCode();
		String city = textInput.promptString("Input City.");
		String function = inputFunction();

		employeeController.createEmployee(name, address, phoneNo, mail, postalCode, city, function);

		System.out.println("Created " + name + ".");
	}

	/**
	 * This method lets you find an employee on their phone number, then prompts the
	 * choices to either update or change their active status.
	 */
	private void printFindEmployeeMenu() {
		String input;
		int choice;
		Employee employee;

		input = inputPhoneNumber();

		employee = employeeController.findEmployeeByPhoneNumber(input);

		if (employee != null) {
			printEmployeeInformation(employee);

			System.out.println("What would you like to do with this Employee.");

			System.out.println("[1] Update Employee Information.\n" + "[2] Change active status of the Employee.\n"
					+ "[0] Cancel.");

			choice = textInput.promptIntBetween("Input valid option.", "Not valid input, try again.", 0, 2);

			switch (choice) {
			case 1:
				printUpdateEmployeeMenu(employee);
				break;
			case 2:
				setActivity(employee);
				break;
			case 0:
				break;
			default:
				break;
			}

		}
	}

	/**
	 * This method prompts the parameters you can update on the given employee
	 * 
	 * @param employee
	 */
	private void printUpdateEmployeeMenu(Employee employee) {
		System.out.println("To Update an Employee's information, please input valid information when requested.");

		String name = textInput.promptString("Input Name.");
		String address = textInput.promptString("Input Address.");
		String phoneNo = inputPhoneNumber();
		String mail = textInput.promptString("Input E-Mail.");
		int postalCode = inputPostalCode();
		String city = textInput.promptString("Input City.");
		String function = inputFunction();

		employeeController.updateEmployee(employee, name, address, phoneNo, mail, postalCode, city, function);

		System.out.println("Updated " + employeeController.getName(employee) + ".");

		printMainEmployeeMenu();
	}

	/**
	 * This method prints the information on the given employee.
	 * 
	 * @param employee
	 */
	private void printEmployeeInformation(Employee employee) {
		System.out.println("Name: " + employeeController.getName(employee));
		System.out.println("Address: " + employeeController.getAddress(employee));
		System.out.println("Phone Number: " + employeeController.getPhoneNo(employee));
		System.out.println("Mail: " + employeeController.getMail(employee));
		System.out.println("Postal Code: " + employeeController.getPostalCode(employee));
		System.out.println("City: " + employeeController.getCity(employee));
		System.out.println("Function " + employeeController.getFunction(employee));
	}

	/**
	 * This method lets you set the active status on an employee and prints their
	 * new status.
	 * 
	 * @param employee
	 */
	private void setActivity(Employee employee) {
		employeeController.setActivity(employee);

		System.out.println(employeeController.getName(employee) + " had his/her status changed to "
				+ employeeController.isActive(employee));
	}

	/**
	 * This method checks that your phone number input is exactly 8 characters long.
	 * 
	 * @return
	 */
	private String inputPhoneNumber() {

		String phoneNumber = textInput.promptString("Input Phone Number. Must be 8 characters long.");

		if (phoneNumber.length() != 8) {
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

	/**
	 * This method lets you add a function to the employee, but at the moment
	 * function has no effect on the system.
	 * 
	 * @return
	 */
	private String inputFunction() {
		String function = "";
		int choice;

		System.out.println("*** Employee functionality ***\n" + "Choose one of the four options.\n"
				+ "[1] Office worker.\n" + "[2] Shop assistant.\n" + "[3] Souschef.\n" + "[4] Manager.");

		choice = textInput.promptIntBetween("Input valid choice.", "Must be one of the four choices.", 1, 4);

		switch (choice) {
		case 1:
			function = "Office worker";
			break;
		case 2:
			function = "Shop assistant";
			break;
		case 3:
			function = "Souschef";
			break;
		case 4:
			function = "Manager";
			break;
		default:
			break;
		}

		return function;
	}

}
