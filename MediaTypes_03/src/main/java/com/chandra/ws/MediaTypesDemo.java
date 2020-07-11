package com.chandra.ws;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
class Person
{
	public int pid;
	public String pname;
	public String address;
	
	public Person(int pid, String pname, String address) {
		this.pid = pid;
		this.pname = pname;
		this.address = address;
	}
	
	
}

@Path("/media")
public class MediaTypesDemo {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/plain")
	public String plainText()
	{
		return "Welcome to Restful plain text";
	}
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/html")
	public String htmlText()
	{
		return "<center><h1>Welcome to HTML Text</h1></center>";
	}
	@GET
	@Produces(MediaType.TEXT_XML)
	@Path("/xml")
	public String xmlText()
	{
		return "<student id='100'><name>abc</name></student>";
		
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/json")
	
	public List<Person> jsonText()
	{
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person(100,"abc","Hyd"));
		persons.add(new Person(200,"pqr","Hyd"));
		persons.add(new Person(300,"xyz","Hyd"));
		return persons;
	}

}
