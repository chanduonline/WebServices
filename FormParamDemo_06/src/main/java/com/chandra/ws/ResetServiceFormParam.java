package com.chandra.ws;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/customers")
public class ResetServiceFormParam {
    @POST
    @Path("/addCustomer")
	public Response getResultByPassingValues(@FormParam("nameKey")String name, @FormParam("countryKey")String country) {
		String output = "Web Service has added your Customer Name : " + name + " Country  : " + country;
		return Response.status(200).entity(output).build();
	}

}
