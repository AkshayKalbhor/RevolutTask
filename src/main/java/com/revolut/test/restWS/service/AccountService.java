package com.revolut.test.restWS.service;

import java.util.List;

import com.revolut.test.restWS.model.Account;


public interface AccountService {

	/**
	 * API to create Account
	 * 
	 * @param firstName
	 * @param lastName
	 */
	public String createAccount(String firstName, String lastName, int accountNo);
	
	
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
	 * @return 
	 */
	public List<Account> getAllAccounts();
	
	/**
	 * API to find the account details by account ID.
	 * @param accountNumber
	 * @return {@link Account}
	 * @author kalbhor
	 */
	public Account getAccountByNumber(int accountNumber);
	
	/**
	 * API to topup the account with some amount.
	 * @author kalbhor
	 * @param amount
	 * @return
	 */
	public double addBalance(int accountNumber, double amount);
	
	/**
	 * 
	 * API for transferring amount from one account to another 
	 * 
	 * @param fromAccountNo
	 * @param toAccountNo
	 * @param amount
	 * @return
	 * @author kalbhor
	 */
	public String transferAmount(int fromAccountNo, int toAccountNo, double amount);
	
}
