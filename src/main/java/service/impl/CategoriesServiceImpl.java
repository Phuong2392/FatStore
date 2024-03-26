package service.impl;

import java.util.List;

import dao.AccountDao;
import dao.CategoriesDao;
import dao.impl.AccountDaoImpl;
import dao.impl.CategoriesDaoImpl;
import entity.Categories;
import service.CategoriesService;

public class CategoriesServiceImpl implements CategoriesService{
	private CategoriesDao dao;
	public CategoriesServiceImpl() {
		dao = new CategoriesDaoImpl();
	}

	@Override
	public List<Categories> getAllCategories() {
		return dao.getAllCategories();
	}
}
