package com.revolut.test.restWS.service;

import java.util.List;

import javax.ws.rs.Path;

import com.revolut.test.restWS.DAO.AccountDAO;
import com.revolut.test.restWS.DAO.AccountDAOImpl;
import com.revolut.test.restWS.model.Account;

@Path("accountService")
public class AccountServiceImpl implements AccountService {

	AccountDAO accountDAO = new AccountDAOImpl();
	
	/* (non-Javadoc)
	 * @see revolutTest.moneyTransferApp.service.AccountService#AddAccount()
	 */
	public String createAccount(String firstName, String lastName, int accountNo) {
		return accountDAO.createAccount(firstName, lastName, accountNo);
	}

	/* (non-Javadoc)
	 * @see revolutTest.moneyTransferApp.service.AccountService#getAccountBalance(java.lang.Long)
	 */
	public String getAccountBalance(int accountNumber) {
		return accountDAO.getAccountBalance(accountNumber);
	}

	/* (non-Javadoc)
	 * @see revolutTest.moneyTransferApp.service.AccountService#getAllAccounts()
	 */
	public List<Account> getAllAccounts() {
		return null;
		// TODO Auto-generated method stub
	}
	
	/* (non-Javadoc)
	 * @see com.rest.test.restprj.service.AccountService#getAccountByNumber(int)
	 */
	public Account getAccountByNumber(int accountNumber) {
		return accountDAO.getAccountByNumber(accountNumber);
	}

	/* (non-Javadoc)
	 * @see com.rest.test.restprj.service.AccountService#addBalance(double)
	 */
	public double addBalance(int accountNumber, double amount) {
		return accountDAO.addBalance(accountNumber, amount);
	}

	/* (non-Javadoc)
	 * @see com.rest.test.restprj.service.AccountService#transferAmount(int, int, double)
	 */
	public String transferAmount(int fromAccountNo, int toAccountNo, double amount) {
		return accountDAO.transferAmount(fromAccountNo, toAccountNo, amount);
	}

}
