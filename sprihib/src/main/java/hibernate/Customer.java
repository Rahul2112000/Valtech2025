package hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Customer {

	
		@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "custseq")
		@SequenceGenerator(name = "custseq" , sequenceName = "cust_seq",allocationSize = 1)
		private long id;
		private String name;
		private int age;
		private boolean gender;
		//mappedBy is the field on the child where join column definition is declared.
		
		@OneToOne(targetEntity = Address.class , mappedBy="customer")
		private Address address;
		@ManyToMany(targetEntity = Account.class,fetch = FetchType.LAZY)
		@JoinTable(name = "customer_account",
		joinColumns = @JoinColumn(name="customer_id" , referencedColumnName = "id")
		,inverseJoinColumns = @JoinColumn(name="account_id",referencedColumnName = "id"))
		private Set<Account> accounts;
		
		
		public Customer() {
			
		}
		
		
		
		public Customer(String name, int age, boolean gender) {
			
			this.name = name;
			this.age = age;
			this.gender = gender;
		}
		public void removeAccount(Account ac) {
			accounts.remove(ac);
			ac.getCustomers().remove(this);
			
			
		}
		
		public void addAccount(Account ac) {
			if(accounts==null) accounts= new HashSet<Account>();
			accounts.add(ac);
			if(ac.getCustomers()==null) ac.setCustomers(new HashSet<Customer>());
			ac.getCustomers().add(this);
			
		}
		
		
		
		


		@Override
		public String toString() {
			return "Customer [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", address="
					+ address + "]";
		}



		public Set<Account> getAccounts() {
			return accounts;
		}
		public void setAccounts(Set<Account> accounts) {
			this.accounts = accounts;
		}

		public Address getAddress() {
			return address;
		}
		
		public void setAddress(Address address) {
			this.address = address;
		}

		public long getId() {
			return id;
		}
		public void setId(long id) {
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
		public boolean isGender() {
			return gender;
		}
		public void setGender(boolean gender) {
			this.gender = gender;
		}
		
		
}
