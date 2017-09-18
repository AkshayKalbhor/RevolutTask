package com.revolut.test.restWS.DAO;

import java.util.List;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.ws.rs.Path;

import com.revolut.test.restWS.model.Account;

@Singleton
@Path("accountDAO")
public class AccountDAOImpl implements AccountDAO {
	
	private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("h2");
	private final EntityManager entityManager = entityManagerFactory.createEntityManager();
	//EntityTransaction transaction = entityManager.getTransaction();

	/* (non-Javadoc)
	 * @see revolutTest.moneyTransferApp.DAO.AccountDAO#AddAccount()
	 */
	public String createAccount(String firstName, String lastName, int accountNo) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		//entityManager.getTransaction().begin();
		Account newAccount = new Account(firstName, lastName, accountNo, 0.0);
		entityManager.persist(newAccount);
		transaction.commit();
		//entityManager.getTransaction().commit();
		return "accountCreated, Balance is "+newAccount.getBalance();
	}

	/* (non-Javadoc)
	 * @see revolutTest.moneyTransferApp.DAO.AccountDAO#getAccountBalance(java.lang.Long)
	 */
	public String getAccountBalance(int accountNumber) {
		Account a = getAccountByNumber(accountNumber);
		if(null == a) {
			throw new IllegalArgumentException("wrong accountNumber");
		}
		return a.getBalance().toString();
	}

	/* (non-Javadoc)
	 * @see revolutTest.moneyTransferApp.DAO.AccountDAO#getAllAccounts()
	 */
	public List<Account> getAllAccounts() {
		 /*Session session = ((org.hibernate.SessionFactory) sessionFactory).openSession();
	        return session.createCriteria(Account.class).list();*/
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.rest.test.restprj.DAO.AccountDAO#getAccountByNumber(int)
	 */
	public Account getAccountByNumber(int accountNumber) {
		Account fetchedAccount = entityManager.find(Account.class, accountNumber);
		return fetchedAccount;
	}

	/* (non-Javadoc)
	 * @see com.rest.test.restprj.DAO.AccountDAO#addBalance(int, double)
	 */
	public double addBalance(int accountNumber,double amount) {
		Account fetchedAccount = entityManager.find(Account.class, accountNumber);
		if(null == fetchedAccount) {
			throw new IllegalArgumentException("Account not found");
		} else {
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			
			//entityManager.getTransaction().begin();
			fetchedAccount.setBalance(fetchedAccount.getBalance()+amount);
			entityManager.persist(fetchedAccount);
			transaction.commit();
			//entityManager.getTransaction().commit();
			return fetchedAccount.getBalance();
		}
	}

	/* (non-Javadoc)
	 * @see com.rest.test.restprj.DAO.AccountDAO#transferAmount(int, int, double)
	 */
	public String transferAmount(int fromAccountNo, int toAccountNo, double amount) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Account fromAccount = entityManager.find(Account.class, fromAccountNo);
		if(fromAccount == null)
			throw new IllegalArgumentException("Source account does not exist");
		fromAccount.setBalance(fromAccount.getBalance()-amount);
		
		
		Account toAccount = entityManager.find(Account.class, toAccountNo);
		if(toAccount == null)
			throw new IllegalArgumentException("Source account does not exist");
		
		toAccount.setBalance(toAccount.getBalance()+amount);
		
		entityManager.persist(fromAccount);
		entityManager.persist(toAccount);
		
		transaction.commit();
		return "Account number "+fromAccount.getAccountNumber() +" debited, New balance is "+fromAccount.getBalance() +" Account number "+ toAccount.getAccountNumber() +" credited, New balance is "+toAccount.getBalance();
	}

}
