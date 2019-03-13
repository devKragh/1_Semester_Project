package modelLayer;

public class Customer extends Person {
	
	private boolean credit;
	
	public Customer(String name, String address, String phoneNo, String mail, int postalCode, String city) {
		super(name, address, phoneNo, mail, postalCode, city);
		this.setActive(true);

	}

	public boolean getCredit() {
		return credit;
	}

	public void setCredit(boolean credit) {
		this.credit = credit;
	}
	
}
