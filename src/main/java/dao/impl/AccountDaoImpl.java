package dao.impl;

import java.util.List;

import dao.AbstractDao;
import dao.AccountDao;
import entity.Account;

public class AccountDaoImpl extends AbstractDao<Account> implements AccountDao{

	@Override
	public Account findById(String username) {
		return super.findById(Account.class, username);
	}

	@Override
	public Account findByEmail(String email) {
		String sql = "SELECT o FROM Account o WHERE o.email = ?0";
		return super.findOne(Account.class, sql, email);
	}

	@Override
	public Account findByUsernameAndPassword(String username, String password) {
		String sql = "SELECT o FROM Account o WHERE o.username = ?0 AND o.password = ?1";
		return super.findOne(Account.class, sql, username, password);
	}

	@Override
	public List<Account> findAll() {
		return super.findAll(Account.class, true);
	}

	@Override
	public List<Account> findAll(int pageNumber, int pageSize) {
		return super.findAll(Account.class, true, pageNumber, pageSize );
	}
}
