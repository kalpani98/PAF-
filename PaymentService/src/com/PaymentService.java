package com;

import model.Payment;
//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;
@Path("/Payment")

public class PaymentService{

	Payment itemObj = new Payment();
	
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
	public String insertItem(@FormParam("PaymentID") int PaymentID,
	 @FormParam("BillAmount") String CustomerName,
	 @FormParam("BillAmount") String BillAmount,
	 @FormParam("AccountNo") String AccountNo)
	{
	 String output = itemObj.insertItem(PaymentID,CustomerName, BillAmount, AccountNo);
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
	 String PaymentID = itemObject.get("PaymentID").getAsString();
	 String CustomerName = itemObject.get("CustomerName").getAsString();
	 String BillAmount = itemObject.get("BillAmount").getAsString();
	 String AccountNo = itemObject.get("AccountNo").getAsString();

	 String output = itemObj.updateItem(PaymentID, CustomerName, BillAmount, AccountNo);
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

	//Read the value from the element <PaymentID>
	 String PaymentID = doc.select("PaymentID").text();
	 String output = itemObj.deleteItem(PaymentID);
	return output;
	}

}