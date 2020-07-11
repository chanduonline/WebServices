package com.chandra.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/customers")
public class JsonFromResultService {
	@GET
	@Path("/{cusNo}")
	@Produces("application/json")
	public Customer prduceCustomerDetails(@PathParam("cusNo") int no) {
		Customer cust = new Customer();
		cust.setCustNo(no);
		cust.setCustName("Chandra");
		cust.setCustCountry("India");
		return cust;
	}

}
