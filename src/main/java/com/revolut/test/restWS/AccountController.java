package com.revolut.test.restWS;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.revolut.test.restWS.model.Account;
import com.revolut.test.restWS.service.AccountServiceImpl;


@Path("/account")
public class AccountController {
	
	AccountServiceImpl accountService = new AccountServiceImpl();
	
	@GET
    @Path("test")
    @Produces(MediaType.TEXT_PLAIN)
    public String test() {
        return "Test";
    }

	@Path("/create/{firstName}/{lastName}/{accountNo}")
	@POST
	public Response createAccount(@PathParam(value = "firstName") String firstName,
			@PathParam(value = "lastName") String lastName, 
			@PathParam(value = "accountNo") int accountNo) {
		
			Account acc = accountService.getAccountByNumber(accountNo);
			if(null == acc) {
				accountService.createAccount(firstName, lastName, accountNo);	
				return Response.status(Response.Status.CREATED).build();
			} else {
				/*throw new IllegalArgumentException("E001: Account number already exist");*/
				return Response.status(Response.Status.FORBIDDEN).build();
			}
	}

	@Path("/viewBalance/{accountNo}")
	@GET
	public String getAccountBalance(@PathParam("accountNo") int accountNumber) {
		return accountService.getAccountBalance(accountNumber);
	}
	
	@GET
    @Path("/getAllAccounts")
	public String getAllAccounts() {
		ArrayList<Account> allAccounts = new ArrayList<>(accountService.getAllAccounts());
        return allAccounts.toString();
	}
	
	@PUT
	@Path("/topup/{accountNo}/{amount}")
	public double addBalance(@PathParam("accountNo") int accountNumber,
			@PathParam("amount") double amount) {
		return accountService.addBalance(accountNumber, amount);
	}
	
	@POST
	@Path("/transfer/{fromAccountNo}/{toAccountNo}/{amount}")
	public Response transferAmount(@PathParam("fromAccountNo") int fromAccountNo,
			@PathParam("toAccountNo") int toAccountNo,
			@PathParam("amount") double amount) {
		String responseText = accountService.transferAmount(fromAccountNo, toAccountNo, amount);
		return Response.status(200).entity(responseText).build();
	}
	
}
