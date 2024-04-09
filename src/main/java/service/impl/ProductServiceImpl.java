package service.impl;

import java.util.List;

import dao.ProductDao;
import dao.impl.ProductDaoImpl;
import entity.Products;
import service.ProductService;

public class ProductServiceImpl implements ProductService {
	private ProductDao dao;
	public ProductServiceImpl() {
		dao = new ProductDaoImpl();
	}

	@Override
	public Products findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public Products findByCategoris(Integer cateid) {
		return dao.findByCategoris(cateid);
	}

	@Override
	public List<Products> findAllEntities() {
		return dao.findAllEntities();
	}

	@Override
	public List<Products> findAll(int pageNumber, int pageSize) {
		return dao.findAll(pageNumber, pageSize);
	}

	@Override
	public List<Products> findFirstSixProducts() {
		return dao.findFirstSixProducts();
	}

	@Override
	public Products create(Products entity) {
		return dao.create(entity);
	}

	@Override
	public Products update(Products entity) {
		return dao.update(entity);
	}

	@Override
	public Products delete(Products entity) {
		return dao.delete(entity);
	}
}
