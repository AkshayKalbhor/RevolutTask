package com.rest.test.restprj.service;

public interface AccountService {

	/**
	 * API to create Account
	 * 
	 * @param firstName
	 * @param lastName
	 */
	public String createAccount(String firstName, String lastName, int accountNo);
	
	/**
	 * @author kalbhor
	 * @param sourceAccount
	 * @param DestinationAccount
	 * @param amount
	 * 
	 * API for transferring money from one account to another
	 */
	public void transfer(int sourceAccount, int DestinationAccount, Long amount);
	
	/**
	 * API for retrieving the account balance of the account.
	 * 
	 * @author kalbhor
	 * @param accountNumber
	 * @return 
	 */
	public String getAccountBalance(int accountNumber);
	
	/**
	 * API for retrieving all the accounts in the system.
	 * 
	 * @author kalbhor
	 */
	public void getAllAccounts();
	
}
