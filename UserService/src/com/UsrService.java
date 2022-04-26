package com;

import model.Usr;
//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;
@Path("/Usr")

public class UsrService{

	Usr itemObj = new Usr();
	
//	@GET
//	@Path("/")
//	@Produces(MediaType.TEXT_HTML)
//	public String readItems()
//	{
//	return "Hello";
//	}
	
	//GET
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readItems()
	{
		return itemObj.readItems();
	}
	
	//POST
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertItem(@FormParam("UserName") String UserName,
	 @FormParam("Password") String Password,
	 @FormParam("Name") String Name,
	 @FormParam("EmailID") String EmailID)
	{
	 String output = itemObj.insertItem(UserName, Password, Name, EmailID);
	return output;
	}
	
	//PUT
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateItem(String itemData)
	{
	//Convert the input string to a JSON object
	 JsonObject itemObject = new JsonParser().parse(itemData).getAsJsonObject();
	//Read the values from the JSON object
	 String ID = itemObject.get("ID").getAsString();
	 String UserName = itemObject.get("UserName").getAsString();
	 String Password = itemObject.get("Password").getAsString();
	 String Name = itemObject.get("Name").getAsString();
	 String EmailID = itemObject.get("EmailID").getAsString();
	 String output = itemObj.updateItem(ID, UserName, Password, Name, EmailID);
	return output;
	}
	
	//DELETE
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteItem(String itemData)
	{
	//Convert the input string to an XML document
	 Document doc = Jsoup.parse(itemData, "", Parser.xmlParser());

	//Read the value from the element <ID>
	 String ID = doc.select("ID").text();
	 String output = itemObj.deleteItem(ID);
	return output;
	}

}