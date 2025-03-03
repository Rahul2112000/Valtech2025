package ass.services;



import java.util.List;

import ass.classes.Order;

public interface OrderService {

	void statusOfOrder(int id, String status);
	void addOrder(Order order);
	Order getOrder(int id);
	List<Order> getAll();
	void updateOrder(Order order);
	void deleteOrder(int id);
}