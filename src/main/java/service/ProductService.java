package service;

import java.util.List;

import entity.Products;

public interface ProductService {
	Products findById(Integer id);

	Products findByCategoris(Integer cateid);

	List<Products> findAll();

	List<Products> findAll(int pageNumber, int pageSize);
	
	List<Products> findFirstSixProducts();

	Products create(Products entity);

	Products update(Products entity);

	Products delete(Products entity);
}
