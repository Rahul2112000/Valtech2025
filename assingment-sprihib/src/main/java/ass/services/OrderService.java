package ass.services;
 
import java.util.List;
 
import ass.classes.OrderEx;
 
public interface OrderService {
 
	void statusOfOrder(int id, String status);

	void addOrder(OrderEx order);

	OrderEx getOrder(int id);

	List<OrderEx> getAll();

	void updateOrder(OrderEx order);

	void deleteOrder(int id);

}
 