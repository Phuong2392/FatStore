package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import constant.Session;
import entity.Account;
import service.AccountService;
import service.impl.AccountServiceImpl;

@WebServlet(urlPatterns = { "/login", "/logout", "/register", "/forgotPass" })
public class AccountController extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AccountService accountService = new AccountServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String path = req.getServletPath();
		switch (path) {
		case "/login":
			doGetLogin(req, resp);
			break;
		case "/logout":
	    	doGetLogout(session,req,resp);
	    	break;
//		case "/register":
//			doGetRegister(req, resp);
//			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String path = req.getServletPath();
		switch (path) {
		case "/login":
			doPostLogin(session, req, resp);
			break;
		case "/register":
			doPostRegister(session, req, resp);
			break;
		
		}
	}
	
	private void doGetLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/user/Login.jsp").forward(req, resp);	
	}
	
	private void doGetLogout(HttpSession session,HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		session.removeAttribute(Session.CURRENT_USER);
		resp.sendRedirect("index");	
	}

	private void doPostRegister(HttpSession session, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");// lấy giá trị username bằng Parameter
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");
		
		Account account = accountService.register(username, password, email, phone, address);
		if (account != null) {
			session.setAttribute(Session.CURRENT_USER, account);
			resp.sendRedirect("index");
		} else {
			resp.sendRedirect("register");
		}
	}

	
	
	
	private void doPostLogin(HttpSession session, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		Account account = accountService.login(username, password);
		if(account != null) {
			session.setAttribute(Session.CURRENT_USER,account);
			resp.sendRedirect("index");
		} else {
			resp.sendRedirect("login");
		}
	}
}
