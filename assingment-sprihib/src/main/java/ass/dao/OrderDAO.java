package ass.dao;
 
import java.util.List;
 
import ass.classes.OrderEx;
 
public interface OrderDAO {
 
	void addOrder(OrderEx order);

	OrderEx getOrder(int id);

	List<OrderEx> getAll();

	void updateOrder(OrderEx order);

	void deleteOrder(int id);

}
 