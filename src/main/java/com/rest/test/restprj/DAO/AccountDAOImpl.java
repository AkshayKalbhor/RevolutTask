package com.rest.test.restprj.DAO;

import javax.ws.rs.Path;

@Path("accountDAO")
public class AccountDAOImpl implements AccountDAO {

	/* (non-Javadoc)
	 * @see revolutTest.moneyTransferApp.DAO.AccountDAO#AddAccount()
	 */
	public String createAccount(String firstName, String lastName, int accountNo) {
		return "accountCreated";
	}

	/* (non-Javadoc)
	 * @see revolutTest.moneyTransferApp.DAO.AccountDAO#Transfer(java.lang.Long, java.lang.Long, java.lang.Long)
	 */
	public void transfer(Long sourceAccount, Long DestinationAccount, Double amount) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see revolutTest.moneyTransferApp.DAO.AccountDAO#getAccountBalance(java.lang.Long)
	 */
	public String getAccountBalance(int accountNumber) {
		return "200";
	}

	/* (non-Javadoc)
	 * @see revolutTest.moneyTransferApp.DAO.AccountDAO#getAllAccounts()
	 */
	public void getAllAccounts() {
		// TODO Auto-generated method stub

	}

}
