package com.valetch.training.first.repos;
 
import java.util.List;
 
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;
 
import com.valetch.training.first.dtos.BookInfoDTO;

import com.valetch.training.first.entites.Book;
 
@Repository

public interface BookRepo extends JpaRepository<Book, Integer> {

	List<Book> findAllByYearBetween(int min, int max);

	List<Book> findAllByPriceGreaterThan(int price);

	List<Book> findAllByAuthorsId(int authorId);

	@Query("SELECT b.price FROM Book b JOIN b.authors a WHERE a.id = ?1")

	List<Integer> findAllPriceByAuthorsId(int id);

	@Query("SELECT new com.valetch.training.first.dtos.BookInfoDTO(b.publisher.name,b.price) FROM Book b JOIN b.authors a WHERE a.id = ?1")

	List<BookInfoDTO> getBookInfoByAuthor(long id);


 
}

 