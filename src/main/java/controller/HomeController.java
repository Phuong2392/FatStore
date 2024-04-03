package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CategoriesDao;
import entity.Categories;
import entity.Products;
import service.CategoriesService;
import service.ProductService;
import service.impl.CategoriesServiceImpl;
import service.impl.ProductServiceImpl;

@WebServlet(urlPatterns = { "/index", "/myorder"})
public class HomeController extends HttpServlet{
	private CategoriesService categoriesService = new CategoriesServiceImpl();
	private ProductService productService = new ProductServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String path = req.getServletPath();
		switch (path) {
		case "/index":
			doGetIndex(req, resp);
			break;
		case "/myorder":
			doGetMyOrder(session, req, resp);
			break;
	}
}

	private void doGetMyOrder(HttpSession session, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/user/myorder.jsp").forward(req, resp);
	}

	private void doGetIndex(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Categories> categories = categoriesService.getAllCategories();
		List<Products> products = productService.findFirstSixProducts();
		req.setAttribute("products", products);
		req.setAttribute("categories", categories);
		req.getRequestDispatcher("/views/user/index.jsp").forward(req, resp);
	}
}
