package com.example.registerservicenetflix.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.registerservicenetflix.entities.User;
@Repository
public interface UserRepo extends JpaRepository<User, Long>{
	List<User> findAllByKidTrue();
}
