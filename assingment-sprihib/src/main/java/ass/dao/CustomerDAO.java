package ass.dao;
 
import java.util.List;
 
import ass.classes.Customer;
 
public interface CustomerDAO {

	void addCustomer(Customer customer);

	Customer getCustomer(int id);

	List<Customer> getAll();

	void updateCustomer(Customer customer);

	void deleteCustomer(int id);
 
}
 