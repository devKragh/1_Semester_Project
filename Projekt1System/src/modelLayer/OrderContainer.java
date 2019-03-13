package modelLayer;
import java.util.ArrayList;

public class OrderContainer {
	private static OrderContainer instance; 
	private ArrayList<Order> orders; 
	
	private OrderContainer() {
		orders = new ArrayList<>();
	}

	public static OrderContainer getInstance() {
		if(instance == null) {
			instance = new OrderContainer(); 
		}
		return instance;
	}
	
	public void addOrder(Order order) {
		orders.add(order);
	}
	
	public Order getOrderById(int orderId) {
		Order res = null;
		for(Order element : orders) {
			if(element.getOrderId() == orderId) {
				res = element;
			}
		}
		return res;
	}
	
	public ArrayList<Order> getOrders() {
		return orders;
	}
	
	
}
