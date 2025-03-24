package com.example.registerservicenetflix.entities;

import java.time.LocalDate;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
	@SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
	private long id;
	private String name;
	private int age;
	private String mobileNo;
	private String email;
	private LocalDate subscriptionStart;
	private LocalDate subscriptionEnd;
	private boolean kid;
	@OneToOne(targetEntity = Subscription.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Subscription subscription;

	public User() {

	}

	

	public User(long id, String name, int age, String mobileNo, String email, boolean kid) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.mobileNo = mobileNo;
		this.email = email;
	
		this.kid = kid;
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

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSubscriptionStart(LocalDate subscriptionStart) {
		this.subscriptionStart = subscriptionStart;
	}

	public void setSubscriptionEnd(LocalDate subscriptionEnd) {
		this.subscriptionEnd = subscriptionEnd;
	}

	public LocalDate getSubscriptionEnd() {
		return subscriptionEnd;
	}

	public LocalDate getSubscriptionStart() {
		return subscriptionStart;
	}
	public void setKid(boolean kid) {
		this.kid = kid;
	}
	
	public boolean isKid() {
		return kid;
	}
	
	

}
