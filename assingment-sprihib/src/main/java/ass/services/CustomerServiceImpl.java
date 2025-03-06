package ass.services;
 
import java.util.List;
 
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.orm.hibernate3.HibernateTemplate;

import org.springframework.stereotype.Repository;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Propagation;

import org.springframework.transaction.annotation.Transactional;
 
import ass.classes.Customer;

import ass.dao.CustomerDAO;
 
 
@Transactional(propagation = Propagation.REQUIRED)

public class CustomerServiceImpl implements CustomerService {

	@Autowired

	private CustomerDAO customerDAO;

	public void setCustomerDAO(CustomerDAO customerDAO) {

		this.customerDAO = customerDAO;

	}

	@Override

	public void addCustomer(Customer customer) {

		customerDAO.addCustomer(customer);

	}
 
	@Override

	public Customer getCustomer(int id) {

		return customerDAO.getCustomer(id);

	}
 
	@Override

	public List<Customer> getAll() {

		return customerDAO.getAll();

	}
 
	@Override

	public void updateCustomer(Customer customer) {

		customerDAO.updateCustomer(customer);

	}
 
	@Override

	public void deleteCustomer(int id) {

		customerDAO.deleteCustomer(id);

	}
 
}

 