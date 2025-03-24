package assignment;

import java.util.List;

public interface EmployeeService {

	// emp by level
	List<Employee> getEmpByLevel(List<Employee> emps, int level);

	// emp by name
	List<Employee> getEmpByName(List<Employee> emps, String name);

	// emp by ignore case
	List<Employee> getEmpByIgnoreCase(List<Employee> emps, String name);

	// emp by id
	List<Employee> getEmpById(List<Employee> emps, long id);

	// get sum of salary
	double getSumOfSalary(List<Employee> employees);

}