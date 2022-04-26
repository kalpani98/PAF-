package com;

import model.Bill;
//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;
@Path("/Bill")

public class BillService{

	Bill itemObj = new Bill();
	
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
	public String insertItem(@FormParam("AccNo") int AccNo,
	 @FormParam("BillAmount") String CustomerName,
	 @FormParam("BillAmount") String BillAmount,
	 @FormParam("Date") String Date,
	 @FormParam("Email") String Email)
	{
	 String output = itemObj.insertItem(AccNo,CustomerName, BillAmount, Date, Email);
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
	 String AccNo = itemObject.get("AccNo").getAsString();
	 String CustomerName = itemObject.get("CustomerName").getAsString();
	 String BillAmount = itemObject.get("BillAmount").getAsString();
	 String Date = itemObject.get("Date").getAsString();
	 String Email = itemObject.get("Email").getAsString();
	 String output = itemObj.updateItem(AccNo, CustomerName, BillAmount, Date, Email);
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

	//Read the value from the element <AccNo>
	 String AccNo = doc.select("AccNo").text();
	 String output = itemObj.deleteItem(AccNo);
	return output;
	}

}