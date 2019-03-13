package controlLayer;

import modelLayer.Employee;
import modelLayer.EmployeeContainer;

public class EmployeeController {
	private EmployeeContainer employeeContainer;

	public EmployeeController() {
		employeeContainer = EmployeeContainer.getInstance();
	}

	/**
	 * This method takes the given parameters and creates an employee object and
	 * adds it to the container.
	 * 
	 * @param name
	 * @param address
	 * @param phoneNo
	 * @param mail
	 * @param postalCode
	 * @param city
	 * @param function
	 * @return
	 */
	public Employee createEmployee(String name, String address, String phoneNo, String mail, int postalCode,
			String city, String function) {
		Employee employee = new Employee(name, address, phoneNo, mail, postalCode, city, function);
		employeeContainer.addEmployee(employee);
		return employee;
	}

	/**
	 * This method gets an employee and some new data, then set the parameters on
	 * the object to the new information
	 * 
	 * @param employee
	 * @param name
	 * @param address
	 * @param phoneNo
	 * @param mail
	 * @param postalCode
	 * @param city
	 * @param function
	 */
	public void updateEmployee(Employee employee, String name, String address, String phoneNo, String mail,
			int postalCode, String city, String function) {
		employee.setName(name);
		employee.setAddress(address);
		employee.setPhoneNo(phoneNo);
		employee.setMail(mail);
		employee.setPostalCode(postalCode);
		employee.setCity(city);
		employee.setFunction(function);
	}

	/**
	 * This method gets an employee and switches active attribute, to set the
	 * employee as either active or not active in the system.
	 * 
	 * @param employee
	 */
	public void setActivity(Employee employee) {
		if (employee.isActive() == true) {
			employee.setActive(false);
		} else {
			employee.setActive(true);
		}
	}

	/**
	 * This method gets a phone number and searches for the employee by that phone
	 * number
	 * 
	 * @param phoneNumber
	 * @return employee
	 */
	public Employee findEmployeeByPhoneNumber(String phoneNumber) {
		return employeeContainer.getEmployeeByPhoneNumber(phoneNumber);
	}
	
	public String getName(Employee employee) {
		return employee.getName();
	}

	public boolean isActive(Employee employee) {
		return employee.isActive();
	}

	public String getAddress(Employee employee) {
		return employee.getAddress();
	}

	public String getCity(Employee employee) {
		return employee.getCity();
	}

	public int getPostalCode(Employee employee) {
		return employee.getPostalCode();
	}

	public String getPhoneNo(Employee employee) {
		return employee.getPhoneNo();
	}

	public String getMail(Employee employee) {
		return employee.getMail();
	}

	public String getFunction(Employee employee) {
		return employee.getFunction();
	}
}
