package dao;

import java.util.List;

import entity.Order;

public interface OrderDao {
	List<Order> findByUsername(String username);

	List<Order> findAll();

	List<Order> findAll(int pageNumber, int pageSize);

	Order create(Order entity);

	Order update(Order entity);

	Order delete(Order entity);
}
