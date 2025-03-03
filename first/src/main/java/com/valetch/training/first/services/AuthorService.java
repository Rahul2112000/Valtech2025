package com.valetch.training.first.services;
 
import java.util.List;
import com.valetch.training.first.entites.Author;
 
public interface AuthorService {
    Author saveAuthor(Author author);
    Author updateAuthor(Author author);
    void deleteAuthor(Author author);
    Author getAuthor(int id);
    List<Author> getAllAuthors();
    long countAuthors();
	List<Author> findAll();
}
 
 