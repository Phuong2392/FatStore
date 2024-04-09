package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Products;
import service.CategoriesService;
import service.ProductService;
import service.impl.CategoriesServiceImpl;
import service.impl.ProductServiceImpl;

@WebServlet(urlPatterns = { "/products" })
public class ProductController extends HttpServlet {

	private ProductService productService = new ProductServiceImpl();
	private static final int PRODUCT_MAX_PAGE_SIZE = 9;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Products> countProduct = productService.findAllEntities();
		int maxPage = (int) Math.ceil(countProduct.size() / (double) PRODUCT_MAX_PAGE_SIZE);
		req.setAttribute("maxPage", maxPage);

		List<Products> products;
		String pageNumber = req.getParameter("page");

		if (pageNumber == null || Integer.valueOf(pageNumber) > maxPage) {
			products = productService.findAll(1, PRODUCT_MAX_PAGE_SIZE);
			req.setAttribute("currentPage", 1);
		} else {
			products = productService.findAll(Integer.valueOf(pageNumber), PRODUCT_MAX_PAGE_SIZE);
			req.setAttribute("currentPage", pageNumber);
		}
		req.setAttribute("products", products);

		req.getRequestDispatcher("/views/user/product.jsp").forward(req, resp);
	}
}
