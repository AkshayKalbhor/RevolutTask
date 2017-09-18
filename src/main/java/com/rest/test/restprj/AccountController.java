package com.rest.test.restprj;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rest.test.restprj.service.AccountServiceImpl;


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
	public String createAccount(@PathParam(value = "firstName") String firstName,
			@PathParam(value = "lastName") String lastName, 
			@PathParam(value = "accountNo") int accountNo) {
		
		return accountService.createAccount(firstName, lastName, accountNo);
	}

	@Path("/viewBalance/{accountNo}")
	@GET
	public String getAccountBalance(@PathParam("accountNumber") int accountNumber) {
		return accountService.getAccountBalance(accountNumber);
	}
}
