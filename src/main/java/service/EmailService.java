package service;

import javax.servlet.ServletContext;

import entity.Account;

public interface EmailService {
	void sendEmail(ServletContext context, Account recipient, String type);
}
