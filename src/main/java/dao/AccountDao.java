package dao;

import java.util.List;

import entity.Account;

public interface AccountDao {
	Account findById(String username);
	Account findByEmail(String email);
	Account findByUsernameAndPassword(String username, String password);
	List<Account> findAll();
	List<Account> findAll(int pageNumber, int pageSize);
	Account create(Account entity);
	Account update(Account entity);
	Account delete(Account entity);
}
