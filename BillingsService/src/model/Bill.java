package model;

import java.sql.*;

//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;

public class Bill {
	//A common method to connect to the DB
	private Connection connect()
	{
		Connection con = null;
		try
			{
				Class.forName("com.mysql.jdbc.Driver");
				//Provide the correct details: DBServer/DBName, usersname, password
				con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/lab", "root", "");
			}
		catch (Exception e)
			{
				e.printStackTrace();
			}
			return con;
	}
	
	public String insertItem(int No, String code, String name, String price, String desc)
	{
	   String output = "";
		try
		{
			Connection con = connect();
			if (con == null)
		{
			
			return "Error while connecting to the database for inserting."; 
		}
	
		  // create a prepared statement
			String query = " insert into Billing(`AccNo`,`CustomerName`,`BillAmount`,`Date`,`Email`)"+ " values (?, ?, ?, ?, ?)";
	        PreparedStatement preparedStmt = con.prepareStatement(query);
	       
	      // binding values
			preparedStmt.setInt(1, No);
			preparedStmt.setString(2, code);
			preparedStmt.setString(3, name);
			preparedStmt.setString(4,price);
			preparedStmt.setString(5, desc);
	
		  // execute the statement
			preparedStmt.execute();
			con.close();
			output = "Inserted successfully";
		}
		catch (Exception e)
		{
			output = "Error while inserting the item.";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	public String readItems()
	{
		String output = "";
		  try
		  {
			  Connection con = connect();
			  if (con == null)
		  {	
			  return "Error while connecting to the database for reading."; 
	      }
			  
		  	// Prepare the html table to be displayed
			  output = "<table border='1'><tr><th>AccNo</th><th>CustomerName</th>" +
					  "<th>BillAmount</th>" +
					  "<th>Date</th>"+
					  "<th>Email/Phone</th>";
			  String query = "select * from Billing";
			  Statement stmt = con.createStatement();
			  ResultSet rs = stmt.executeQuery(query);
		
		   // iterate through the rows in the result set
		  
		  while (rs.next())
		  {
				String AccNo = Integer.toString(rs.getInt("AccNo"));
				String CustomerName = rs.getString("CustomerName");
				String BillAmount = rs.getString("BillAmount");
				String Date = rs.getString("Date");
				String Email = rs.getString("Email");
				// Add into the html table
				output += "<tr><td>" + AccNo + "</td>";
				output += "<td>" + CustomerName + "</td>";
				output += "<td>" + BillAmount + "</td>";
				output += "<td>" + Date + "</td>";
				output += "<td>" + Email + "</td>";
		  }
				con.close();
				// Complete the html table
				output += "</table>";
		  }
		  catch (Exception e)
		  {
				output = "Error while reading the Billing.";
				System.err.println(e.getMessage());
		  }
		return output;
	}
	
	public String updateItem(String AccNo, String code, String name, String price, String desc)
	{
		String output = "";
		  try
		  {
			  Connection con = connect();
			  if (con == null)
		  {
			  return "Error while connecting to the database for updating."; 
		  }
			  
			  // create a prepared statement
				  String query = "UPDATE Billing SET CustomerName=?,BillAmount=?,Date=?,Email=? WHERE AccNo=?";
				  PreparedStatement preparedStmt = con.prepareStatement(query);
			  
			  // binding values
				preparedStmt.setString(1, code);
				preparedStmt.setString(2, name);
				preparedStmt.setString(3, price);
				preparedStmt.setString(4, desc);
				preparedStmt.setInt(5, Integer.parseInt(AccNo));
			 
			  // execute the statement
				preparedStmt.execute();
				con.close();
				output = "Updated successfully";
		  }
		  catch (Exception e)
		  {
				output = "Error while updating the item.";
				System.err.println(e.getMessage());
		  }
		return output;
	}
			
	public String deleteItem(String AccNo)
	{
		String output = "";
		  try
		  {
			  	Connection con = connect();
			  	if (con == null)
		  {
				return "Error while connecting to the database for deleting."; 
		  }
			  	
			// create a prepared statement
			  	String query = "delete from Billing where AccNo=?";
			  	PreparedStatement preparedStmt = con.prepareStatement(query);
			
			// binding values
			  	preparedStmt.setInt(1, Integer.parseInt(AccNo));
			
			// execute the statement
			  	preparedStmt.execute();
			  	con.close();
			  	output = "Deleted successfully";
		  }
		  catch (Exception e)
		  {
			  	output = "Error while deleting the item.";
			  	System.err.println(e.getMessage());
		  }
		  return output;
			}
	}
