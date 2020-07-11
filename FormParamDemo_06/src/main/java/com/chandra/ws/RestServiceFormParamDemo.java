package com.chandra.ws;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/customer")
public class RestServiceFormParamDemo {
	@POST
	@Path("/addCustomer")
	@Produces("text/html")
	public Response getResultByPassingValue(@FormParam("nameKey") String name,
			@FormParam("countryKey") String country) {
		String output = "Web service has added your customer information  with name " + name + " Country " + country
				+ "";
		return Response.status(200).entity(output).build();

	}

}
