package dao;

import java.util.ArrayList;

import java.util.List;

import java.util.Map;

import java.util.Objects;

import java.util.stream.Collectors;

public class Employee implements Comparable<Employee> {

	public enum Gender {

		MALE, FEMALE, OTHER;

	}

	private String name;

	private int id;

	private int age;

	private int level;

	private float salary;

	private int experience;

	private Gender gender;

	private int deptId;

	private String deptName;

	private String deptLocation;

	public Employee() {
	}

	public Employee(int id, String name, int age, Gender gender, float salary, int experience, int level) {

		this.id = id;

		this.name = name;

		this.age = age;

		this.gender = gender;

		this.salary = salary;

		this.experience = experience;

		this.level = level;

	}

	// Constructor With deptId (Use When deptId is Available)

	public Employee(int id, String name, int age, Gender gender, float salary, int experience, int level, int deptId) {

		this.id = id;

		this.name = name;

		this.age = age;

		this.gender = gender;

		this.salary = salary;

		this.experience = experience;

		this.level = level;

		this.deptId = deptId;

	}

	// Getters and setters

	public String getName() {

		return name;

	}

	public void setName(String name) {

		this.name = name;

	}

	public long getId() {

		return id;

	}

	public void setId(int id) {

		this.id = id;

	}

	public int getAge() {

		return age;

	}

	public void setAge(int age) {

		this.age = age;

	}

	public int getLevel() {

		return level;

	}

	public void setLevel(int level) {

		this.level = level;

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

	public Gender getGender() {

		return gender;

	}

	public void setGender(Gender gender) {

		this.gender = gender;

	}

	public void setDeptName(String deptName)

	{

		this.deptName = deptName;

	}

	public void setDeptLocation(String deptLocation)

	{

		this.deptLocation = deptLocation;

	}

	public int getDeptId() {
		return deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public String getDeptLocation() {
		return deptLocation;
	}

	@Override

	public String toString() {

		return "Employee [name=" + name + ", id=" + id + ", age=" + age + ", level=" + level + ", salary=" + salary

				+ ", experience=" + experience + ", gender=" + gender + "]";

	}

	@Override

	public int hashCode() {

		return Objects.hash(name, id, age, level, salary, experience, gender);

	}

	@Override

	public boolean equals(Object obj) {

		if (this == obj)

			return true;

		if (obj == null || getClass() != obj.getClass())

			return false;

		Employee other = (Employee) obj;

		return id == other.id && age == other.age && level == other.level && Float.compare(other.salary, salary) == 0
				&& experience == other.experience && Objects.equals(name, other.name) && gender == other.gender;

	}

	public static EmployeeBuilder builder() {

		return new EmployeeBuilder(new Employee());

	}

	public static class EmployeeBuilder {

		private Employee employee;

		public EmployeeBuilder(Employee employee) {

			this.employee = employee;

		}

		public Employee build() {

			return employee;

		}

		public EmployeeBuilder id(int id) {

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

		public EmployeeBuilder gender(Gender gender) {

			employee.setGender(gender);

			return this;

		}

	}

	@Override

	public int compareTo(Employee o) {

		int result = Integer.compare(level, o.level);

		if (result != 0)
			return result;

		result = Integer.compare(experience, o.experience);

		if (result != 0)
			return result;

		result = gender.compareTo(o.gender);

		if (result != 0)
			return result;

		return Float.compare(salary, o.salary);

	}

	public static void main(String[] args) {

		Employee obj = new Employee(1, "Roy", 22, Gender.MALE, 30000, 2, 5);

		System.out.println(obj);

	}

}
