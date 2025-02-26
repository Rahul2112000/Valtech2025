package hib1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Cust1 {
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "cutseq")
	@SequenceGenerator(name = "cutseq",sequenceName = "cut_seq",allocationSize = 1)x
		
	private int id;
	private String name;
	private int age;
	private String address;
	private String per_add;
	
	
	
	
	public Cust1() {
		
	}
	public Cust1(String name, int age, String address, String per_add) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
		this.per_add = per_add;
	}
	@Override
	public String toString() {
		return "Cust1 [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + ", per_add=" + per_add
				+ "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPer_add() {
		return per_add;
	}
	public void setPer_add(String per_add) {
		this.per_add = per_add;
	}
	
	
	
}
