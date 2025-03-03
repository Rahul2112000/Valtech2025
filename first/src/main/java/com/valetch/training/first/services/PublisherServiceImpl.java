package com.valetch.training.first.services;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
 
import com.valetch.training.first.entites.Publisher;
import com.valetch.training.first.repos.PublisherRepo;
 
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class PublisherServiceImpl implements PublisherService {
 
    @Autowired
    private PublisherRepo publisherRepository;
 
    @Override
    public Publisher savePublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }
 
    @Override
    public Publisher updatePublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }
 
    @Override
    public void deletePublisher(Publisher publisher) {
        publisherRepository.delete(publisher);
    }
 
    @Override
    public Publisher getPublisher(int id) {
        return publisherRepository.getReferenceById(id);
    }
 
    @Override
    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }
 
    @Override
    public long countPublishers() {
        return publisherRepository.count();
    }

	@Override
	public List<Publisher> findAll() {
		// TODO Auto-generated method stub
		return publisherRepository.findAll();
	}
 
	
}
 
 