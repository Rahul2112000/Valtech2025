package assignment;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeServiceImpl implements EmployeeService {
//	Employee by level
	@Override
	public List<Employee> getEmpByLevel(List<Employee> emps, int level) {
		return emps.stream().filter(employee -> employee.getLevel() == level).collect(Collectors.toList());
	}

//	Employee by name
	@Override
	public List<Employee> getEmpByName(List<Employee> emps, String name) {
		return emps.stream().filter(employee -> employee.getName().contains(name)).collect(Collectors.toList());
	}

//	Employee by ignore case
	@Override
	public List<Employee> getEmpByIgnoreCase(List<Employee> emps, String name) {
		return emps.stream().filter(employee -> !employee.getName().contains(name)).collect(Collectors.toList());
	}

//	Employee by id
	@Override
	public List<Employee> getEmpById(List<Employee> emps, long id) {
		return emps.stream().filter(employee -> employee.getId() == id).collect(Collectors.toList());
	}

//	get sum of salary
	@Override
	public double getSumOfSalary(List<Employee> employees) {
		return employees.stream().mapToDouble(Employee::getSalary).sum();
	}
}
