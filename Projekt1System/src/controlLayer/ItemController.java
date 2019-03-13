package controlLayer;

import modelLayer.Item;
import modelLayer.ItemContainer;
import modelLayer.Product;

public class ItemController {
	private ItemContainer itemContainer;

	public ItemController() {
		itemContainer = ItemContainer.getInstance();
	}

	/**
	 * This method takes the given parameters and creates an Item object and adds it
	 * to the container.
	 * 
	 * @param price
	 * @param description
	 * @param name
	 * @param barcode
	 * @param active
	 * @param quantity
	 * @return the Item object
	 */
	public Item createItem(double price, String description, String name, String barcode, boolean active,
			int quantity) {
		Item item = new Product(price, description, name, barcode, active, quantity);
		itemContainer.addItem(item);
		return item;
	}

	/**
	 * This method gets an item and some new data, then set the parameters on the
	 * object to the new information
	 * 
	 * @param item
	 * @param price
	 * @param description
	 * @param name
	 * @param active
	 * @return the Item with the new information
	 */
	public Item updateItem(Item item, double price, String description, String name, boolean active) {
		item.setPrice(price);
		item.setDescription(description);
		item.setName(name);
		item.setActive(active);
		return item;
	}

	/**
	 * This method gets an item and switches active attribute, to set the item as
	 * either active or not active in the system.
	 * 
	 * @param item
	 */
	public void setActivity(Item item) {
		if (item.isActive() == true) {
			item.setActive(false);
		} else {
			item.setActive(true);
		}
	}

	/**
	 * This method gets a name and searches for the Item by that name
	 * 
	 * @param name
	 * @return an Item object
	 */
	public Item findItemByName(String name) {
		Item item = itemContainer.getItemByName(name);
		return item;
	}

	/**
	 * This method receives an item and add the quantity to the stock
	 * 
	 * @param item
	 * @param quantity
	 */
	public void addQuantityToItem(Item item, int quantity) {
		item.addToQuantity(quantity);
	}

	/**
	 * This method receives an item and a quantity, then checks if the quantity
	 * smaller or equal to the items stock quantity. If it is, it withdraws the
	 * quantity from stock
	 * 
	 * @param item
	 * @param quantity
	 * @return item
	 */
	public Item removeQuantity(Item item, int quantity) {
		if (item.getQuantity() >= quantity) {
			item.withdrawQuantity(quantity);
		} else {
			item = null;
		}
		return item;
	}
}
