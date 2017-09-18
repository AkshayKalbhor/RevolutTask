package com.rest.test.restprj.service;

import javax.ws.rs.Path;

import com.rest.test.restprj.DAO.AccountDAO;
import com.rest.test.restprj.DAO.AccountDAOImpl;

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
	 * @see revolutTest.moneyTransferApp.service.AccountService#Transfer(java.lang.Long, java.lang.Long, java.lang.Long)
	 */
	public void transfer(int sourceAccount, int DestinationAccount, Long amount) {

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
	public void getAllAccounts() {
		// TODO Auto-generated method stub
	}

}
