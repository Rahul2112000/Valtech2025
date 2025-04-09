package ass.services;
 
import java.util.List;
 
import org.springframework.orm.hibernate3.HibernateTemplate;
 
import ass.classes.OrderEx;

import ass.dao.OrderDAO;
 
public class OrderServiceImpl implements OrderService {
 
	private OrderDAO orderDAO;

	public void setOrderDAO(OrderDAO orderDAO) {

		this.orderDAO = orderDAO;

	}

	@Override

	public OrderEx getOrder(int id) {

		return orderDAO.getOrder(id);

	}
 
	@Override

	public void addOrder(OrderEx order) {

		orderDAO.addOrder(order);

	}
 
	@Override

	public List<OrderEx> getAll() {

		return orderDAO.getAll();

	}
 
	@Override

	public void updateOrder(OrderEx order) {

		orderDAO.updateOrder(order);

	}
 
	@Override

	public void deleteOrder(int id) {

		orderDAO.deleteOrder(id);

	}

	@Override

	public void statusOfOrder(int id, String status) {

		OrderEx order=getOrder(id);

		if(order !=null) {

			order.setStatus(status);

			updateOrder(order);

		}

	}

//	@Override
//	public void getOrder(OrderEx order) {
//		return orderDAO.getOrder(order);
//
//		
//	}
 
}

 