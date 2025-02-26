package spring.test;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.tx.Employee;
//import spring.tx.Employee.Gender;
//import spring.tx.Employee.Gender;
import spring.tx.EmployeeService;
import spring.tx.Employee.Gender;

public class TxClient {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("tx-hib-ann.xml");
		//Arrays.asList(null)
		EmployeeService es=ctx.getBean(EmployeeService.class);
		System.out.println(es.getClass().getName());
		es.update(new Employee(10,"ten",10,10000,10,10,Gender.FEMALE));
		es.getAll().forEach(e->System.out.println(e));
		ctx.close();

	}

}
