package modelLayer;

public class Person {
	private String name;
	private String address;
	private String phoneNo;
	private String mail;
	private int postalCode;
	private String city;
	private boolean active;
	private int id;
	private static int nextID = 1;
	
	
	public Person(String name, String address, String phoneNo, String mail, int postalCode, String city) {
		setName(name);
		setAddress(address);
		setPhoneNo(phoneNo);
		setMail(mail);
		setPostalCode(postalCode);
		setCity(city);
		
		this.active = true;
		
		id = nextID++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public boolean isActive() {
		return active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
	
}
