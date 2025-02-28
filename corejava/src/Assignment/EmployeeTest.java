package Assignment;

import Assignment.Employee.Gender;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import Assignment.Employee;

class EmployeeTest {

    @Test
    void testHashCode() {
        Employee emp1 = new Employee(200, "Badal", 22, 30000, 1, 12, Gender.MALE);
        Employee emp2 = new Employee(100, "Mayank", 21, 20000, 3, 16, Gender.MALE);
        
        assertEquals(emp1.hashCode(), emp1.hashCode());
        assertNotEquals(emp1.hashCode(), emp2.hashCode());
    }

    @Test
    void testEquals() {
        Employee emp1 = new Employee(200, "Badal", 22, 30000, 1, 12, Gender.MALE);
        Employee emp2 = new Employee(100, "Mayank", 22, 30000, 1, 16, Gender.MALE);
        
        assertFalse(emp1.equals(emp2));
    }

   

    @Test
    void testStreamOperations() {
        List<Employee> employees = Arrays.asList(
            Employee.builder().id(1).name("Kiran").age(23).salary(50000).gender(Gender.MALE).experience(3).level(2).build(),
            Employee.builder().id(2).name("Deepak").age(12).salary(20000).gender(Gender.MALE).experience(5).level(5).build(),
            Employee.builder().id(3).name("Lokesh").age(45).salary(80000).gender(Gender.FEMALE).experience(7).level(8).build(),
            Employee.builder().id(4).name("Badal").age(32).salary(90000).gender(Gender.MALE).experience(4).level(8).build(),
            Employee.builder().id(5).name("Riya").age(45).salary(430000).gender(Gender.FEMALE).experience(2).level(2).build(),
            Employee.builder().id(6).name("Sameer").age(32).salary(23000).gender(Gender.MALE).experience(6).level(12).build()
        );

        employees.forEach(System.out::println);
        
        

        // Filter employees with salary > 10,000
        List<Employee> highSal = employees.stream()
                .filter(emp -> emp.getSalary() > 10000)
                .collect(Collectors.toList());
        highSal.forEach(System.out::println);

        // Employees with name "Badal" (case insensitive)
        List<Employee> nameFilter = employees.stream()
                .filter(emp -> emp.getName().equalsIgnoreCase("Badal"))
                .collect(Collectors.toList());
        nameFilter.forEach(System.out::println);

       
        // Employees grouped by gender
        Map<Gender, List<String>> empByGender = employees.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.mapping(Employee::getName, Collectors.toList())));
        empByGender.forEach((gender, names) -> System.out.println(gender + " -> " + names));

        // Employees sorted by name
        List<Employee> sortedByName = employees.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.toList());
        sortedByName.forEach(System.out::println);

        
        // Total salary per level
        Map<Integer, Double> salaryByLevel = employees.stream()
                .collect(Collectors.groupingBy(Employee::getLevel, Collectors.summingDouble(Employee::getSalary)));
        salaryByLevel.forEach((level, totalSalary) -> System.out.println("Level " + level + " -> " + totalSalary));

        // Total salary per gender
        Map<Gender, Double> salaryByGender = employees.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.summingDouble(Employee::getSalary)));
        salaryByGender.forEach((gender, totalSalary) -> System.out.println(gender + " -> " + totalSalary));
    }
}





























//package Assignment;
// 
//import static org.junit.jupiter.api.Assertions.*;
// 
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
// 
//import org.junit.jupiter.api.Test;
// 
//import Assignment.Employee.Gender;
// 
//class EmployeeTest {
//	@Test
//	void test() {
//		Employee.builder().id(1).name("Rahul").age(21).level(3).salary(10000).experience(1).gender(Gender.MALE).build();
//		Employee.builder().id(1).name("Saini").age(23).level(2).salary(25000).experience(4).gender(Gender.MALE).build();
//		Employee.builder().id(1).name("Kiran").age(19).level(3).salary(56000).experience(2).gender(Gender.FEMALE).build();
//		Employee.builder().id(1).name("Badal").age(22).level(1).salary(105000).experience(8).gender(Gender.MALE).build();
//		Employee.builder().id(1).name("Honey singh").age(35).level(1).salary(431000).experience(5).gender(Gender.MALE).build();
//		Employee.builder().id(1).name("Mika").age(42).level(2).salary(11000).experience(8).gender(Gender.TRANS).build();
//		Employee.builder().id(1).name("Mayank").age(19).level(2).salary(36000).experience(2).gender(Gender.FEMALE).build();
//		System.out.println(" LIST OF ALL EMPLOYEES ");
//		
//		Collections.sort(Employee.allEmp);
//		for (Employee emps : Employee.allEmp) {
//			System.out.println(emps);
//		}
//		
//		System.out.println(" OUTPUT");
//		double emp1= Employee.getEmployeeByLevel(3);
//		System.out.println(emp1);
//
//				System.out.println("OUTPUT");
//		double emp2= Employee.getEmployeeByGender(Gender.MALE);
//		System.out.println("Salary Sum By Gender = " + emp2);
//		System.out.println("OUTPUT");
//		double emp3= Employee.getEmployeeByName("Mika");
//		System.out.println(emp3);
//		System.out.println("OUTPUT");
//		double emp4= Employee.getEmployeeByGenderLevel(2,Gender.FEMALE);
//		System.out.println(emp4);
//		System.out.println("OUTPUT");
//		Map<Gender,List<Employee>> emp5= Employee.getEmployeeByGender();
//		System.out.println("All Employee List By Gender  = " + emp5);
//		System.out.println("OUTPUT");
//
//	}
//}