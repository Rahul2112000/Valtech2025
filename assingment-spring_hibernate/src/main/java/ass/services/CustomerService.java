package ass.services;
 
import java.util.List;
 
import ass.classes.Customer;
 
public interface CustomerService {
 
	void addCustomer(Customer customer);

	Customer getCustomer(int id);

	List<Customer> getAll();

	void updateCustomer(Customer customer);

	void deleteCustomer(int id);

	void update(Customer customer);


 
}
 