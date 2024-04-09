package dao;

import java.util.List;

import entity.Products;

public interface ProductDao {
	Products findById(Integer id);

	Products findByCategoris(Integer cateid);

	List<Products> findAllEntities();

	List<Products> findAll(int pageNumber, int pageSize);
	
	List<Products> findFirstSixProducts();

	Products create(Products entity);

	Products update(Products entity);

	Products delete(Products entity);
}