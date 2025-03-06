package Assignment;

import java.util.*;
import java.lang.module.ModuleDescriptor.Builder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Employee implements Comparable<Employee>{
	
	public enum Gender{
		MALE,FEMALE,TRANS;
		
	}
	public Gender gender;
	private long id;
	private String name;
	private int age;
	private float salary;
	private int experience;
	private int level;
	
	
	
	public Employee() {
	
		// TODO Auto-generated constructor stub
	}
	
	
	public Employee(long id, String name, int age, float salary, int experience, int level,Gender gender) {
	
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.experience = experience;
		this.level = level;
		this.gender=gender;
		allEmp.add(this);
	}

	public static List<Employee> allEmp=new ArrayList<Employee>();
	
	private static Map<Gender,List<Employee>> getEmployeeMap=new HashMap<Gender,List<Employee>>();
	public static List allEmployee;
	
	public static Map<Gender,List<Employee>> getEmployeeByGender(){
		return allEmp.stream().collect(Collectors.groupingBy(e->e.gender));
		
	}
	public static double getEmployeeByLevel(int level) {
		List<Employee> emp=allEmp.stream().filter(e->e.level==level).collect(Collectors.toList());
		System.out.println(emp);
		return allEmp.stream().filter(e->e.level==level).mapToDouble(Employee::getSalary).sum()	;
		}	
	
	public static double getEmployeeByGender(Gender gender) {
		List<Employee> emp=allEmp.stream().filter(e->e.gender.equals(gender)).collect(Collectors.toList());
		System.out.println(emp);
		return allEmp.stream().filter(e->e.gender.equals(gender)).mapToDouble(Employee::getSalary).sum()	;
		}	
	
	public static double getEmployeeByName(String name) {
		List<Employee> emp=allEmp.stream().filter(e->e.name.equals(name)).collect(Collectors.toList());
		System.out.println(emp);
		return allEmp.stream().filter(e->e.name.equals(name)).mapToDouble(Employee::getSalary).sum()	;
		}	
	
	public static double getEmployeeByGenderLevel(int level,Gender gender) {
		List<Employee> emp=allEmp.stream().filter(e->e.gender.equals(gender) && e.level==level).collect(Collectors.toList());
		System.out.println(emp);
		return allEmp.stream().filter(e->e.gender.equals(gender) && e.level==level).mapToDouble(Employee::getSalary).sum()	;
		}
	
	
	
	
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id2) {
		this.id = id2;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(age, experience, id, level, name, salary);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return age == other.age && experience == other.experience && id == other.id && level == other.level
				&& Objects.equals(name, other.name)
				&& Float.floatToIntBits(salary) == Float.floatToIntBits(other.salary);
	}
//	@Override
//	public String toString() {
//		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + ", experience="
//				+ experience + ", level=" + level + "]";
//	}
	
	
	
	@Override
	public String toString() {
	    return "id: " + id + " ,name:" + name + " ,age: " + age + " ,experience: " + experience + 
	           " ,salary: " + salary + " ,level: " + level + ", Gender: " + gender;
	}

	public static EmployeeBuilder builder() {
		return new EmployeeBuilder(new Employee());
		}
	
	public static class EmployeeBuilder{
		private Employee employee;
		
		public EmployeeBuilder(Employee employee) {
			this.employee=employee;
		}
		public Employee build() {
			allEmp.add(employee);
			return employee;
		}
		
		public EmployeeBuilder id(long id) {
			employee.setId(id);
			return this;
		}
		
		public EmployeeBuilder name(String name) {
			employee.setName(name);
			return this;
		}
		
		public EmployeeBuilder age(int age) {
			employee.setAge(age);
			return this;
		}
		
		public EmployeeBuilder salary(float salary) {
			employee.setSalary(salary);
			return this;
		}
		
		public EmployeeBuilder level(int level) {
			employee.setLevel(level);
			return this;
		}
		
		public EmployeeBuilder experience(int experience) {
			employee.setExperience(experience);
			return this;
		}
		
		public EmployeeBuilder gender(Gender string) {
			employee.setGender(string);
			return this;
		}
		
		
		
	}
	@Override
	public int compareTo(Employee o) {
		if(this.level!=o.level)
			return level-o.level;
		else if(this.experience!=o.experience) {
			return experience-o.experience;
		}
		
		int genderComparable=this.gender.compareTo(o.gender);
		if(genderComparable!=0) return genderComparable;
		
		
		/**
		 * else if(this.gender.equals("Male"))
		 * return 1;
		 * else if(this.gender.equals("Female")
		 * return -1;
		 * else if(this.gender.equals("Other"))
		 * return 0;
		
		 */
		else
			return (int)(salary-o.salary);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 public static void main(String[] args) {
		Employee obj=new Employee(7,"Rahul",22,30000,2,5,Gender.MALE);
		System.out.println(obj.toString());
		
	}
	
	
	
}
