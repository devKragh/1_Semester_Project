package modelLayer;

public class Item {
	private double price;
	private String description;
	private int id;
	private static int nextId = 0;
	private String name;
	private String barcode;
	private boolean active;
	private int quantity;

	/**
	 * The constructor for an item which takes the price, description, name, a barcode and a boolean which decides if the item is ready to be sold.
	 * 
	 * @param double price
	 * @param String description
	 * @param String name
	 * @param String barcode
	 * @param boolean active
	 */
	public Item(double price, String description, String name, String barcode, boolean active, int quantity) {
		id = ++nextId;
		setPrice(price);
		setDescription(description);
		setName(name);
		this.barcode = barcode;
		setActive(active);
		setQuantity(quantity);
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBarcode() {
		return barcode;
	}
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity; 
	}

	public int getQuantity() {
		return quantity;
	}

	public void addToQuantity(int quantity) {
		this.quantity += quantity;
	}
	
	public void withdrawQuantity(int quantity) {
		this.quantity -= quantity;
	}
}
