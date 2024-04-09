package service;

import java.util.List;

import entity.OrderDetail;

public interface OrderDetailService {
	OrderDetail findById(Long id);

	List<OrderDetail> findAll();

	List<OrderDetail> findAll(int pageNumber, int pageSize);

	OrderDetail create(OrderDetail entity);

	OrderDetail update(OrderDetail entity);

	OrderDetail delete(OrderDetail entity);
}
