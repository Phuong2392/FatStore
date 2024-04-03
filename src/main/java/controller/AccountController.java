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
import service.EmailService;
import service.impl.AccountServiceImpl;
import service.impl.EmailServiceImpl;

@WebServlet(urlPatterns = { "/login", "/logout", "/forgotPass", "/changePass" })
public class AccountController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AccountService accountService = new AccountServiceImpl();
	private EmailService emailService = new EmailServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String path = req.getServletPath();
		switch (path) {
		case "/login":
			doGetLogin(req, resp);
			break;
		case "/logout":
			doGetLogout(session, req, resp);
			break;
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
		case "/forgotPass":
			doPostForgotPass(req, resp);
			break;
		case "/changePass":
			doPostChangePass(session, req, resp);
			break;
		}
	}

	private void doGetLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/user/Login.jsp").forward(req, resp);
	}

	private void doGetLogout(HttpSession session, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		session.removeAttribute(Session.CURRENT_USER);
		resp.sendRedirect("index");
	}

	private void doPostRegister(HttpSession session, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
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

	private void doPostLogin(HttpSession session, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		Account account = accountService.login(username, password);
		if (account != null) {
			session.setAttribute(Session.CURRENT_USER, account);
			resp.sendRedirect("index");
		} else {
			resp.sendRedirect("login");
		}
	}

	private void doPostChangePass(HttpSession session, HttpServletRequest req, HttpServletResponse resp) {
		resp.setContentType("application/json");
		String oldPass = req.getParameter("oldPass");
		String newPass = req.getParameter("newPass");

		Account currentAccount = (Account) session.getAttribute(Session.CURRENT_USER);
		if (currentAccount.getPassword().equals(oldPass)) {
			currentAccount.setPassword(newPass);
			Account updatedAccount = accountService.update(currentAccount);
			if (updatedAccount != null) {
				session.setAttribute(Session.CURRENT_USER, updatedAccount);
				resp.setStatus(200);
			} else {
				resp.setStatus(400);
			}
		} else {
			resp.setStatus(400);
		}
	}

	private void doPostForgotPass(HttpServletRequest req, HttpServletResponse resp) {
		resp.setContentType("application/json");
		String email = req.getParameter("email");
		Account accountNewPass = accountService.resetPassword(email);
		if (accountNewPass != null) {
			emailService.sendEmail(getServletContext(), accountNewPass, "forgot");
			resp.setStatus(200);
		} else {
			resp.setStatus(400);
		}
	}
}
