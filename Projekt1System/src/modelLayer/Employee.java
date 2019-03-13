package modelLayer;

public class Employee extends Person {

	private String function;
	
	public Employee(String name, String address, String phoneNo, String mail, int postalCode, String city, String function) {
		super(name, address, phoneNo, mail, postalCode, city);
		
		setFunction(function);
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}
	


}
