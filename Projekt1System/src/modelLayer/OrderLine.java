package modelLayer;


public class OrderLine {
	
	private Item item; 
	private int quantity;
	
	public OrderLine() {
		
	}
	
	public int getQuantityOfItems() {
		return quantity;
	}
	
	public Item getItem() {
		return item; 
	}
	/**
	 * This method returns the subTotal for an orderLine, which is the item price times the quantity
	 * @return price
	 */
	public double getPriceOfOrderLine() {
		double res = 0;
		res = quantity * item.getPrice();
		return res;
	}
	
	public void addItem(Item item, int quantity) {
			this.item = item;
			this.quantity = quantity;
	}
}

