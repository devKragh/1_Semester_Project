package uiLayer;

import uiLibary.ITextInput;
import uiLibary.TextInput;

public class MainUI {
	private CustomerUI customerUI;
	private EmployeeUI employeeUI;
	private ItemUI itemUI;
	private OrderUI orderUI;
	private ITextInput textInput;

	public static void main(String[] args) {
		MainUI mainUI = new MainUI();

		mainUI.printMainMenu();
	}

	private MainUI() {
		customerUI = new CustomerUI();
		employeeUI = new EmployeeUI();
		itemUI = new ItemUI();
		orderUI = new OrderUI();
		textInput = new TextInput();
	}

	/**
	 * Prints the main menu, that lets you navigate the system.
	 */
	private void printMainMenu() {
		boolean running = true;
		while (running) {
			int choice;

			System.out.println("*** Main Menu ***");
			System.out.println("To get to a specific menu, please input the corresponding number listed");
			System.out.println("[1] Customer Menu.\n" + "[2] Employee Menu.\n" + "[3] Item Menu.\n"
					+ "[4] Order Menu.\n" + "[0] Exit.");

			choice = textInput.promptIntBetween(
					"To get to a specific menu, please input the corresponding number listed",
					"Has to be one of the available options.", 0, 4);

			switch (choice) {
			case 1:
				customerUI.printMainCustomerMenu();
				break;
			case 2:
				employeeUI.printMainEmployeeMenu();
				break;
			case 3:
				itemUI.printMainItemMenu();
				break;
			case 4:
				orderUI.printMainOrderMenu();
				break;
			case 0:
				running = false;
				break;
			default:
				break;
			}
		}
	}

}
