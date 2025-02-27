import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import dao.Employee;
import dao.Employee.Gender;

class EmployeeTest {

	@Test
	void test() {
		Employee.builder().id(1).name("Rahul").age(21).level(3).salary(10000).experience(1).gender(Gender.MALE).build();
		Employee.builder().id(1).name("Badal").age(22).level(1).salary(105000).experience(8).gender(Gender.MALE).build();
		Employee.builder().id(1).name("Mayank").age(19).level(2).salary(36000).experience(2).gender(Gender.FEMALE).build();
	}
	@Test
	void testHashCode() {
		Employee employee = new Employee(12, "Badal", 22, 2, 30000, 5, Gender.MALE);
		int hash = employee.hashCode();
		System.out.println(employee + " " + employee.hashCode());
		assertEquals(hash, employee.hashCode());
		assertEquals(hash, new Employee(7, "Badal", 22, 2, 30000, 5, Gender.MALE).hashCode());

		employee.setName("Rahul");
		System.out.println(employee + " " + employee.hashCode());
		assertNotEquals(hash, employee.hashCode());
	}

	@Test
	void testEquals() {
		Employee e1 = new Employee(7, "Mayank", 22, 2, 30000, 5, Gender.MALE);
		Employee e2 = new Employee(7, "Mayank", 22, 2, 30000, 5, Gender.MALE);
		assertEquals(e1, e2);

		e2.setName("Sav");
		assertNotEquals(e1, e2);
	}

	@Test
	void testCompareTo() {
		Employee e1 = new Employee(1, "Sav", 25, 3, 50000, 4, Gender.FEMALE);
		Employee e2 = new Employee(2, "Badal", 28, 3, 50000, 6, Gender.MALE);
		Employee e3 = new Employee(3, "Puneet", 30, 2, 40000, 2, Gender.TRANS);

		assertTrue(e1.compareTo(e2) < 0); // Compare by experience
		assertTrue(e2.compareTo(e3) > 0); // Compare by level
	}

	@Test
	void testEmployeeByLevel() {
		Employee e1 = Employee.builder().name("Mayank").gender(Gender.FEMALE).level(3).salary(50000).build();
		Employee e2 = Employee.builder().name("Pankaj").gender(Gender.MALE).level(3).salary(60000).build();
		Employee.allEmp.add(e1);
		Employee.allEmp.add(e2);

		double totalSalary = Employee.getEmployeeByLevel(3);
		assertEquals(110000, totalSalary);
	}

	@Test
	void testEmployeeByGender() {
		Employee.allEmp.clear();
		Employee e1 = Employee.builder().name("Ishita").gender(Gender.FEMALE).salary(40000).build();
		Employee e2 = Employee.builder().name("Sourav").gender(Gender.MALE).salary(60000).build();
		Employee.allEmp.add(e1);
		Employee.allEmp.add(e2);

		double femaleSalary = Employee.getEmployeeByGender(Gender.FEMALE);
		assertEquals(40000, femaleSalary);
	}
}
