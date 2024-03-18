package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAllTheCustomers_requestes {
	
	
	
	@Test
	public void getallthecustomers() {
		System.out.println(" i am in getall the customers");
		
		// Specify the your baseURI information
		RestAssured.baseURI="https://reqres.in";
		
		// Creating the Request object
		RequestSpecification httprequest=RestAssured.given();
		// sending the request to server and also recieveing the response
		Response response=httprequest.request(Method.GET, "/api/users?page=2");
		
		String responseBody=response.getBody().asString();
		
		System.out.println("the value of the response is ===>"+responseBody);
		
		// validation
		int statuscode=response.getStatusCode();
		Assert.assertEquals(statuscode, 200);
		
		
		
		
		
	}

}
