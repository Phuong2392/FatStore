package service;

import java.util.List;

import entity.Account;

public interface AccountService {
	Account findById(String username);
	Account findByEmail(String email);
	Account findByUsername(String username);
	Account login(String username, String password);	
	Account resetPassword(String email);	
	List<Account> findAll();
	List<Account> findAll(int pageNumber, int pageSize);
	Account register(String username, String password, String email, String phone, String address);
	Account update(Account entity);
	Account delete(String username);
}
