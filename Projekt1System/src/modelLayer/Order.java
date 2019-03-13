package modelLayer;
import java.util.ArrayList;


public class Order {
	private int orderId; 
	private int nextOrderId = 1; 
	private Customer customer; 
	private Employee employee; 
	private ArrayList<OrderLine> orderLines; 
	private OrderLine orderLine;
	/**
	 * This constructor creates an order object with a customer on it
	 * @param customer
	 * @param employee
	 */
	public Order(Customer customer, Employee employee) {
		orderId = nextOrderId++; 
		this.customer = customer;
		this.employee = employee;
		orderLines = new ArrayList<>();
	}
/**
 * This constructor creates an order with only the employee
 * @param employee
 */
	public Order(Employee employee) {
		orderId = nextOrderId++;
		this.employee = employee;
		orderLines = new ArrayList<>();
	}
	
	public int getOrderId() {
		return orderId;
	}
	
	public Customer getCustomer() {
		return customer; 
	}
	
	public Employee getEmployee() {
		return employee; 
	}

	public ArrayList<OrderLine> getOrderLines() {
		return orderLines;
	}
	/**
	 * This method takes the item and quantity and adds them to an orderLine, then takes that orderLine
	 * and put it on the orders list of orderLines
	 * @param item
	 * @param quantity
	 */
	public void addOrderLineToOrder(Item item, int quantity) {
		orderLine = new OrderLine();
		orderLine.addItem(item, quantity);
		orderLines.add(orderLine);
	}
	/**
	 * This method gets the subTotal on every orderLine
	 * @return
	 */
	public double getPriceOfOrder() {
		double res = 0;
		for(OrderLine element: orderLines) {
			res += element.getPriceOfOrderLine();
		}
		return res;
	}
	
}
