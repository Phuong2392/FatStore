package dao.impl;

import java.util.List;

import dao.AbstractDao;
import dao.OrderDetailDao;
import entity.OrderDetail;

public class OrderDetailDaoImpl extends AbstractDao<OrderDetail> implements OrderDetailDao{

	@Override
	public OrderDetail findById(String username) {
		// TODO Auto-generated method stub
		return super.findById(OrderDetail.class, username);
	}

	@Override
	public List<OrderDetail> findAll() {
		// TODO Auto-generated method stub
		return super.findAll(OrderDetail.class, true);
	}

	@Override
	public List<OrderDetail> findAll(int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		return super.findAll(OrderDetail.class, true, pageNumber, pageSize);
	}
	



}
