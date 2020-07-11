package com.chandra.ws;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/database")
public class DBCurdOperations {

	public Connection con = DBUtil.getConnection();
	PreparedStatement ps = null;

	@POST
	@Path("/insert/{sid}/{sname}")
	public String insertStudent(@PathParam("sid") int sid, @PathParam("sname") String sname) {
		String msg = null;
		try {
			ps = con.prepareStatement("insert into student values(?,?)");
			ps.setInt(1, sid);
			ps.setString(2, sname);
			int n = ps.executeUpdate();
			if (n != 0) {
				msg = "Successfully Student Record Inserted....";
			} else {
				msg = "Student Record Notable to inserted. Please try again";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msg;
	}

	@GET
	@Path("/get/{sid}")
	public String getStudentInfo(@PathParam("sid") int sid) {
		String msg = "Student Information ";
		try {
			ps = con.prepareStatement("select * from student where id = ?");
			ps.setInt(1, sid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				msg +=id + " " + name;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msg;
	}
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
	public List<Student> getAllStudentsInfo() {
		List<Student> students = new ArrayList<Student>();
		Student student;
		try {
			ps = con.prepareCall("select * from student");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				student = new Student(rs.getInt(1), rs.getString(2));
				students.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return students;
	}
    @PUT
    @Path("/update/{sid}/{sname}")
    public String updateStudent(@PathParam("sid")int sid,@PathParam("sname")String sname){
    	String msg=null;
    	try {
			ps = con.prepareCall("update student set sname=? where id=?");
			ps.setString(1, sname);
			ps.setInt(2, sid);
			int n = ps.executeUpdate();
			if(n!=0){
				msg = "Successfully Student Updated...";
			}else{
				msg="Student Record Notable to updated....";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return msg;
    }
    @DELETE
    @Path("/delete/{sid}")
    public String deleteStudent(@PathParam("sid")int sid)
    {
    	String msg=null;
    	try {
			ps = con.prepareStatement("delete from student where id= ?");
			ps.setInt(1, sid);
			int n = ps.executeUpdate();
			if(n!=0)
			{
				msg = "Successfully Student Record Deleted.....";
			}else{
				msg = "Student Record Notable to Deleted...Please try again...";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return msg;
    }

}
