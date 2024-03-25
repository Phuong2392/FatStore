package service.impl;

import java.util.List;

import dao.AccountDao;
import dao.impl.AccountDaoImpl;
import entity.Account;
import service.AccountService;

public class AccountServiceImpl implements AccountService{
	private AccountDao dao;
	public AccountServiceImpl() {
		dao = new AccountDaoImpl();
	}

	@Override
	public Account findById(String username) {
		return dao.findById(username);
	}

	@Override
	public Account findByEmail(String email) {
		return dao.findByEmail(email);
	}

	@Override
	public Account findByUsername(String username) {
		return dao.findById(username);
	}

	@Override
	public Account login(String username, String password) {
		return dao.findByUsernameAndPassword(username, password);
	}

	@Override
	public Account resetPassword(String email) {
		Account existAccount = findByEmail(email);
		if(existAccount != null) {
			String newPass = String.valueOf((int)(Math.random() * ((9999 - 1000) + 1)) +1000);
			existAccount.setPassword(newPass);
			return dao.update(existAccount);
		}
		return null;
	}

	@Override
	public List<Account> findAll() {
		return dao.findAll();
	}

	@Override
	public List<Account> findAll(int pageNumber, int pageSize) {
		return dao.findAll(pageNumber, pageSize);
	}

	@Override
	public Account register(String username, String password, String email, String phone, String address) {
		Account newAccount = new Account();
		newAccount.setUsername(username);
		newAccount.setPassword(password);
		newAccount.setEmail(email);
		newAccount.setIsactive(Boolean.TRUE);
		newAccount.setIsadmin(Boolean.FALSE);
		return dao.create(newAccount);
	}

	@Override
	public Account update(Account entity) {
		return dao.update(entity);
	}

	@Override
	public Account delete(String username) {
		Account account = dao.findById(username);
		account.setIsactive(Boolean.FALSE);
		return dao.update(account);
	}
}
