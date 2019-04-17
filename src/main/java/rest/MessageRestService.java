/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rest;

/**
 *
 * @author Rodrigo
 */
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
 
@Path("/message")
public class MessageRestService {
 
	@GET
        @Produces(MediaType.APPLICATION_JSON)
	@Path("/{param}")
	public String printMessage(@PathParam("param") String msg) {
 
		String result = "Restful example : " + msg;
 return "{\n" +
"    \"firstName\": \"John\",\n" +
"    \"lastName\": \"Smith\",\n" +
"    \"isAlive\": true,\n" +
"    \"age\": 25,\n" +
"    \"height_cm\": 167.64,\n" +
"    \"address\": {\n" +
"        \"streetAddress\": \"21 2nd Street\",\n" +
"        \"city\": \"New York\",\n" +
"        \"state\": \"NY\",\n" +
"        \"postalCode\": \"10021-3100\"\n" +
"    },\n" +
"    \"phoneNumbers\": [\n" +
"        { \"type\": \"home\", \"number\": \"212 555-1234\" },\n" +
"        { \"type\": \"office\",  \"number\": \"646 555-4567\" }\n" +
"    ]\n" +
"}";
		//return Response.status(200).entity(result).build();
 
	}
 
}