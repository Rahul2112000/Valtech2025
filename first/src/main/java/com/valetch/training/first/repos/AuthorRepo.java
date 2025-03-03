package com.valetch.training.first.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valetch.training.first.entites.Author;
@Repository
public interface AuthorRepo extends JpaRepository<Author, Integer>{

}
