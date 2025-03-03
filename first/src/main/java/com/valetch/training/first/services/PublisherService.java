package com.valetch.training.first.services;
 
import java.util.List;
import com.valetch.training.first.entites.Publisher;
 
public interface PublisherService {
    Publisher savePublisher(Publisher publisher);
    Publisher updatePublisher(Publisher publisher);
    void deletePublisher(Publisher publisher);
    Publisher getPublisher(int id);
    List<Publisher> getAllPublishers();
    long countPublishers();
	List<Publisher> findAll();
	
}
 
 