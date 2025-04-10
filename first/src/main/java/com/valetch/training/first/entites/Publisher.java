package com.valetch.training.first.entites;
 
import java.util.List;
 
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
 
@Entity
@Table(name="babli")
public class Publisher {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "pubseq")
	@SequenceGenerator(name = "pubseq",sequenceName = "pub_seq",allocationSize = 1)
	private int id;
	private String name;
	
	@OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL)
	private List<Book> books;
	
	public Publisher() {
		
	}
 
	public Publisher(int id, String name, List<Book> books) {
		this.name = name;
		this.books = books;
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
 
	public List<Book> getBooks() {
		return books;
	}
 
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	
	
	
	
	
	
	
 
}
 
 