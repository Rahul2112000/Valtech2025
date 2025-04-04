package assignment;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import assignment.Employee.Gender;

class EmployeeTest {

	private EmployeeService empService;
	private List<Employee> employees;

	@BeforeEach
	void setUp() {
		empService = new EmployeeServiceImpl();
		employees = addEmployees();
	}

	@Test
	void testHashCode1() {
		Employee emp1 = new Employee(200, "Badal", 22, 30000, 1, 12, Gender.MALE);
		Employee emp2 = new Employee(100, "Mayank", 21, 20000, 3, 16, Gender.MALE);

		assertEquals(emp1.hashCode(), emp1.hashCode());
		assertNotEquals(emp1.hashCode(), emp2.hashCode());
	}

	@Test
	void testEquals1() {
		Employee emp1 = new Employee(200, "Badal", 22, 30000, 1, 12, Gender.MALE);
		Employee emp2 = new Employee(100, "Mayank", 22, 30000, 1, 16, Gender.MALE);

		assertFalse(emp1.equals(emp2));
	}

	@Test
	void testStreamOperations() {
		employees.forEach(System.out::println);
	}

	@Test
	void testSort() {
		Collections.sort(employees);

		for (Employee e : employees) {
			System.out.println(e);
		}

		Map<Gender, List<Employee>> mapGenderEmp = employees.stream()
				.collect(Collectors.groupingBy(Employee::getGender));

		mapGenderEmp.forEach((gender, names) -> {
			System.out.println("Gender :" + gender);
			names.forEach(e -> System.out.println(e.getName()));
		});
	}

	private List<Employee> addEmployees() {
		return Arrays.asList(
				Employee.builder().id(1).name("Kiran").age(23).salary(5000000).gender(Gender.MALE).experience(3).level(2).build(),
				Employee.builder().id(2).name("Deepak").age(12).salary(2000000).gender(Gender.MALE).experience(5).level(5).build(),
				Employee.builder().id(3).name("Lokesh").age(45).salary(800000).gender(Gender.FEMALE).experience(7).level(8).build(),
				Employee.builder().id(4).name("Badal").age(32).salary(900000).gender(Gender.MALE).experience(4).level(8).build(),
				Employee.builder().id(5).name("Riya").age(45).salary(430000).gender(Gender.FEMALE).experience(2).level(2).build(),
				Employee.builder().id(6).name("Sameer").age(32).salary(23000).gender(Gender.MALE).experience(6).level(12).build()
		);
	}

	@Test
	void testEmpById() {
		List<Employee> myNewEmp = empService.getEmpById(employees, 2);
		assertEquals("Deepak", myNewEmp.get(0).getName());
	}

	@Test
	void testEmpByLevel() {
		List<Employee> myNewEmp = empService.getEmpByLevel(employees, 2);
		double totalSalary = empService.getSumOfSalary(myNewEmp);
		assertEquals(5430000.0, totalSalary);
		assertNotEquals(6790000.0, totalSalary);
	}

	@Test
	void testEmpByName() {
		List<Employee> myNewEmp2 = empService.getEmpByName(employees, "i");
		double totalSalary2 = empService.getSumOfSalary(myNewEmp2);
		assertEquals(5430000.0, totalSalary2);
		assertNotEquals(4910000.0, totalSalary2);
	}

	@Test
	void testEmpByIgnoreCase() {
		List<Employee> myNewEmp4 = empService.getEmpByIgnoreCase(employees, "e");
		double totalSalary4 = empService.getSumOfSalary(myNewEmp4);
		assertEquals(6330000.0, totalSalary4);
		assertNotEquals(450000.0, totalSalary4);
	}
}
