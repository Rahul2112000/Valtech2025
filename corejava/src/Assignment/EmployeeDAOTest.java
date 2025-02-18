package Assignment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Assignment.Employee.Gender;

class EmployeeDAOTest {

	@Test
	void testInsert() {
		EmployeeDAO dao=new EmployeeDAOImpl();
		//dao.save(new Employee(2,"Working",25,15000,6,3,Gender.FEMALE));
		Employee e=new Employee(2,"DEF",25,15000,6,3,Gender.FEMALE);
		//dao.update(e);
//		e=dao.get(2);
//		assertEquals(2, e.getId());
//		assertEquals("DEF", e.getName());
//		assertEquals(25,e.getAge());
//		
//		assertEquals(15000, e.getSalary());
//		assertEquals(Gender.FEMALE,e.getGender());
//		assertEquals(6, e.getExperience());
//		assertEquals(3, e.getLevel());
		
	   // assertTrue(dao.getAll().size()>=1);
		//dao.delete(2);
		
	}

}
