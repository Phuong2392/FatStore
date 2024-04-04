package dao;

import java.util.List;

import entity.OrderDetail;



public interface OrderDetailDao {
	OrderDetail findById(String username);
	List<OrderDetail> findAll();
	List<OrderDetail> findAll(int pageNumber, int pageSize);
	OrderDetail create(OrderDetail entity);
	OrderDetail update(OrderDetail entity);
	OrderDetail delete(OrderDetail entity);

}
