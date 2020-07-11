package com.chandra.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/customers")
public class RestServiceQueryParamDemo {
	@GET
	@Produces("text/html")
	public Response getResultByPassingValues(@QueryParam("nameKey")String name,@QueryParam("countryKey")String country)
	{
		String output = "Customer Name = "+name+", Country Name "+country+"";
		return  Response.status(200).entity(output).build();
	}

}
//http://localhost:8080/QueryParamDemo_05/rest/customers?nameKey=chandra&countryKey=India