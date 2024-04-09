package service;

import java.util.List;

import entity.Account;
import entity.Order;

public interface OrderService {
	List<Order> findByUsername(String username);

	List<Order> findAll();

	List<Order> findAll(int pageNumber, int pageSize);

	Order create(Order entity);

	Order update(Order entity);

	Order delete(Order entity);
}
