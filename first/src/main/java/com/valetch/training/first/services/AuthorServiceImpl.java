package com.valetch.training.first.services;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
 
import com.valetch.training.first.entites.Author;
import com.valetch.training.first.repos.AuthorRepo;
 
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class AuthorServiceImpl implements AuthorService {
 
    @Autowired
    private AuthorRepo authorRepo;
 
    @Override
    public Author saveAuthor(Author author) {
        return authorRepo.save(author);
    }
 
    @Override
    public Author updateAuthor(Author author) {
        return authorRepo.save(author);
    }
 
    @Override
    public void deleteAuthor(Author author) {
        authorRepo.delete(author);
    }
 
    @Override
    public Author getAuthor(int id) {
        return authorRepo.getReferenceById(id);
    }
 
    @Override
    public List<Author> getAllAuthors() {
        return authorRepo.findAll();
    }
 
    @Override
    public long countAuthors() {
        return authorRepo.count();
    }

	@Override
	public List<Author> findAll() {
		// TODO Auto-generated method stub
		return authorRepo.findAll();
	}
}
 
 