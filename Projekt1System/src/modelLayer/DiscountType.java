package modelLayer;

public class DiscountType {
	private String name;
	private double discountAmount; 
	
	public DiscountType(String name, double discountAmount) {
		setName(name);
		setDiscountAmount(discountAmount);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}
	

}
