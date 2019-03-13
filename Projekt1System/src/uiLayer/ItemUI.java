package uiLayer;

import controlLayer.ItemController;
import modelLayer.Item;
import uiLibary.*;

public class ItemUI {

	private ITextInput textInput;
	private ItemController itemController;

	public ItemUI() {
		textInput = new TextInput();
		itemController = new ItemController();
	}

	/**
	 * Prints the main Item/Product menu, where you can create or find an item.
	 */
	public void printMainItemMenu() {
		boolean running = true;
		while (running) {
			int choice;

			System.out.println("[1] Create Item.");
			System.out.println("[2] Find Item.");
			System.out.println("[0] Cancel");

			choice = textInput.promptIntBetween("Input a valid choice.", "That is not a valid choice", 0, 2);

			switch (choice) {
			case 1:
				printCreateItemMenu();
				break;
			case 2:
				printFindItemMenu();
				break;
			case 0:
				running = false;
				break;
			default:
				System.out.println("Invalid input.");
			}
		}
	}

	/**
	 * This method prompts the necessary parameters to create a new item, then sends
	 * them down to the controller.
	 */
	private void printCreateItemMenu() {
		System.out.println("Please input information in the requested order to create a Product");

		String name = textInput.promptString("Input Name.");
		String description = textInput.promptString("Input Description.");
		double price = textInput.promptDouble("Input Price.", "Input a valid Price.");
		String barcode = textInput.promptString("Input Barcode.");
		boolean active = textInput.promptBoolean("Is the product active?");
		int quantity = textInput.promptInt("Input Quantity, if there is any.", "Input a valid Quantity.");

		itemController.createItem(price, description, name, barcode, active, quantity);

		System.out.println("Created.");
	}

	/**
	 * This method lets you find an item, then prints the item menu, where you can
	 * update the information, change the active status on the item or add or
	 * withdraw from the quantity.
	 */
	private void printFindItemMenu() {
		String input;
		int choice;
		Item item;
		int quantity = 0;

		input = textInput.promptString("Input valid Name to find a Product.");

		if (input != "") {

			item = itemController.findItemByName(input);

			if (item != null) {
				boolean running = true;
				while (running) {
					printItemInformation(item);

					System.out.println("[1] Update Product Information.\n"
							+ "[2] Change active status of the Product.\n" + "[3] Add Quantity of Product.\n"
							+ "[4] Withdraw Quantity of Product.\n" + "[0] Cancel.");

					choice = textInput.promptIntBetween("Input valid option.", "Not valid input, try again.", 0, 4);

					switch (choice) {
					case 1:
						printUpdateItemMenu(item);
						break;
					case 2:
						setActivity(item);
						break;
					case 3:
						quantity = textInput.promptInt("Input a Quantity", "Input a valid Quantity");
						itemController.addQuantityToItem(item, quantity);
						break;
					case 4:
						quantity = textInput.promptInt("Input a Quantity", "Input a valid Quantity");
						itemController.removeQuantity(item, quantity);
						break;
					case 0:
						running = false;
						break;
					}
				}
			} else {
				System.out.println("Product not found. Try again.");
				printFindItemMenu();
			}
		} else {
			printFindItemMenu();
		}
	}

	/**
	 * THis method prompts the parameters you can change on the given item, then
	 * sends it to the controller and prints the new item information.
	 * 
	 * @param item
	 */
	private void printUpdateItemMenu(Item item) {
		System.out.println("To Update a Products info, please input valid information when requested.");

		String name = textInput.promptString("Input Name");
		String description = textInput.promptString("Input Description");
		double price = textInput.promptDouble("Input Price", "Input a valid price");
		boolean active = textInput.promptBoolean("Is the product active?");

		itemController.updateItem(item, price, description, name, active);

		System.out.println("Updated " + itemController.findItemByName(name).getName() + ".");

		printMainItemMenu();
	}

	/**
	 * This method lets you set set the active status on a given item, then prints
	 * what the new status is.
	 * 
	 * @param item
	 */
	private void setActivity(Item item) {
		itemController.setActivity(item);
		System.out.println(item.getName() + " had the status changed to: " + item.isActive());
	}

	/**
	 * This method prints all information on a given item.
	 * 
	 * @param item
	 */
	private void printItemInformation(Item item) {
		System.out.println("Name: " + item.getName());
		System.out.println("Price: " + item.getPrice());
		System.out.println("Description: " + item.getDescription());
		System.out.println("Barcode: " + item.getBarcode());
		System.out.println("Active: " + item.isActive());
		System.out.println("Quantity: " + item.getQuantity());
	}
}
