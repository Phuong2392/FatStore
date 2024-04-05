package dao.impl;

import java.util.List;

import dao.AbstractDao;
import dao.OrderDao;
import entity.Order;

public class OrderDaoImpl extends AbstractDao<Order> implements OrderDao{

	@Override
	public Order findById(String username) {
		// TODO Auto-generated method stub
		return super.findById(Order.class, username);
	}

	@Override
	public List<Order> findAll() {
		// TODO Auto-generated method stub
		return super.findAll(Order.class, true);
	}

	@Override
	public List<Order> findAll(int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		return super.findAll(Order.class, true, pageNumber, pageSize);
	}

	
}
