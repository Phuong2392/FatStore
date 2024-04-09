package service.impl;

import java.util.List;

import dao.OrderDao;
import dao.impl.OrderDaoImpl;
import entity.Account;
import entity.Order;
import service.OrderService;

public class OrderServiceImpl implements OrderService {
	private OrderDao dao;

	public OrderServiceImpl() {
		dao = new OrderDaoImpl();
	}

	@Override
	public List<Order> findByUsername(String username) {
		return dao.findByUsername(username);
	}

	@Override
	public List<Order> findAll() {
		return dao.findAll();
	}

	@Override
	public List<Order> findAll(int pageNumber, int pageSize) {
		return dao.findAll(pageNumber, pageSize);
	}

	@Override
	public Order create(Order entity) {
		return dao.create(entity);
	}

	@Override
	public Order update(Order entity) {
		return dao.update(entity);
	}

	@Override
	public Order delete(Order entity) {
		return dao.delete(entity);
	}
}
