package dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import dao.AbstractDao;
import dao.ProductDao;
import entity.Products;

public class ProductDaoImpl extends AbstractDao<Products> implements ProductDao {

	@Override
	public Products findById(Integer id) {
		return super.findById(Products.class, id);
	}

	@Override
	public Products findByCategoris(Integer cateid) {
		String sql = "SELECT o FROM Products o WHERE o.cateid = ?0";
		return super.findOne(Products.class, sql, cateid);
	}

	@Override
	public List<Products> findAll() {
		return super.findAll(Products.class, true);
	}

	@Override
	public List<Products> findAll(int pageNumber, int pageSize) {
		return super.findAll(Products.class, true, pageNumber, pageSize);
	}

	@Override
	public List<Products> findFirstSixProducts() {
		String jpql = "SELECT p FROM Products p";
	    return findMany(Products.class, jpql).subList(0, 6);
	}
}
