package dao.impl;

import java.util.List;

import dao.AbstractDao;
import dao.OrderDao;
import entity.Account;
import entity.Order;

public class OrderDaoImpl extends AbstractDao<Order> implements OrderDao {

	@Override
	public List<Order> findByUsername(String username) {
		String sql = "SELECT o FROM Order o WHERE o.account.username = ?0";
		return super.findMany(Order.class, sql, username);
	}

	@Override
	public List<Order> findAll() {
		return super.findAll(Order.class, true);
	}

	@Override
	public List<Order> findAll(int pageNumber, int pageSize) {
		return super.findAll(Order.class, true, pageNumber, pageSize);
	}
}
