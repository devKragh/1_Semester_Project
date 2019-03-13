package modelLayer;
import java.util.ArrayList; 

public class EmployeeContainer {
	private static EmployeeContainer instance; 
	private ArrayList<Employee> employeeList;
	
	private EmployeeContainer() {
		employeeList = new ArrayList<>();
	}

	public static EmployeeContainer getInstance() {
		if(instance == null) {
			instance = new EmployeeContainer(); 
		}
		return instance;
	}
	
	public void addEmployee(Employee employee) {
		employeeList.add(employee);
	}

	public Employee getEmployeeByPhoneNumber(String phoneNumber) {
		Employee res = null;
		
		for(Employee element: employeeList) {
			if(element.getPhoneNo().equals(phoneNumber) == true) {
				res = element; 
			}
		}
		return res; 
	}
	
	
}
