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
import service.CategoriesService;
import service.impl.CategoriesServiceImpl;

@WebServlet(urlPatterns = { "/index", "/myorder"})
public class HomeController extends HttpServlet{
	private CategoriesService categoriesService = new CategoriesServiceImpl();

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

	private void doGetMyOrder(HttpSession session, HttpServletRequest req, HttpServletResponse resp) {
		
	}

	private void doGetIndex(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Categories> categories = categoriesService.getAllCategories();
		req.setAttribute("categories", categories);
		req.getRequestDispatcher("/views/user/index.jsp").forward(req, resp);
	}
}
