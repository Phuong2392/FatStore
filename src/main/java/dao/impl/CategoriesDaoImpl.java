package dao.impl;

import java.util.List;

import dao.AbstractDao;
import dao.CategoriesDao;
import entity.Categories;

public class CategoriesDaoImpl extends AbstractDao<Categories> implements CategoriesDao{

	@Override
	public List<Categories> getAllCategories() {
		return super.allList(Categories.class);
	}
}
