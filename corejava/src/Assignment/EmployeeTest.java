package Assignment;
 
import static org.junit.jupiter.api.Assertions.*;
 
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
 
import org.junit.jupiter.api.Test;
 
import Assignment.Employee.Gender;
 
class EmployeeTest {
	@Test
	void test() {
		Employee.builder().id(1).name("Rahul").age(21).level(3).salary(10000).experience(1).gender(Gender.MALE).build();
		Employee.builder().id(1).name("Saini").age(23).level(2).salary(25000).experience(4).gender(Gender.MALE).build();
		Employee.builder().id(1).name("Kiran").age(19).level(3).salary(56000).experience(2).gender(Gender.FEMALE).build();
		Employee.builder().id(1).name("Badal").age(22).level(1).salary(105000).experience(8).gender(Gender.MALE).build();
		Employee.builder().id(1).name("Honey singh").age(35).level(1).salary(431000).experience(5).gender(Gender.MALE).build();
		Employee.builder().id(1).name("Mika").age(42).level(2).salary(11000).experience(8).gender(Gender.TRANS).build();
		Employee.builder().id(1).name("Mayank").age(19).level(2).salary(36000).experience(2).gender(Gender.FEMALE).build();
		System.out.println(" LIST OF ALL EMPLOYEES ");
		
		Collections.sort(Employee.allEmp);
		for (Employee emps : Employee.allEmp) {
			System.out.println(emps);
		}
		
		System.out.println(" OUTPUT");
		double emp1= Employee.getEmployeeByLevel(3);
		System.out.println(emp1);

				System.out.println("OUTPUT");
		double emp2= Employee.getEmployeeByGender(Gender.MALE);
		System.out.println("Salary Sum By Gender = " + emp2);
		System.out.println("OUTPUT");
		double emp3= Employee.getEmployeeByName("Mika");
		System.out.println(emp3);
		System.out.println("OUTPUT");
		double emp4= Employee.getEmployeeByGenderLevel(2,Gender.FEMALE);
		System.out.println(emp4);
		System.out.println("OUTPUT");
		Map<Gender,List<Employee>> emp5= Employee.getEmployeeByGender();
		System.out.println("All Employee List By Gender  = " + emp5);
		System.out.println("OUTPUT");

	}
}