package ass.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.orm.hibernate3.HibernateTemplate;

import org.springframework.stereotype.Repository;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Propagation;

import org.springframework.transaction.annotation.Transactional;

import ass.classes.OrderEx;

@Repository

public class OrderDAOImpl implements OrderDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;

	}

	@Override

	public void addOrder(OrderEx order) {

		new HibernateTemplate(sessionFactory).save(order);

	}

	@Override

	public OrderEx getOrder(int id) {

		return new HibernateTemplate(sessionFactory).load(OrderEx.class, id);

	}

	@Override

	public List<OrderEx> getAll() {

		return new HibernateTemplate(sessionFactory).find("from OrderEx");

	}

	@Override

	public void updateOrder(OrderEx order) {

		new HibernateTemplate(sessionFactory).update(order);

	}

	@Override

	public void deleteOrder(int id) {

		new HibernateTemplate(sessionFactory).delete(getOrder(id));

	}

}
