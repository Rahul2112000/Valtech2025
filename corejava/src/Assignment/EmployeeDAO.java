package Assignment;

import java.util.List;

public interface EmployeeDAO {
	
	void save(Employee e);
	
	void update(Employee e);
	
	void delete(int d);
	
	Employee get(int id);
	
	List<Employee> getAll();
	
	

}
