package testcases;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class deletecustomer {
	
	
	@Test
	public void deletethecustomers() {
		System.out.println(" i am in getall the customers");
		
		// Specify the your baseURI information
		RestAssured.baseURI="http://localhost:3000";
		// 54ee
		// Creating the Request object
		RequestSpecification httprequest=RestAssured.given();
		// sending the request to server and also recieveing the response
		Response response=httprequest.request(Method.DELETE, "/customers/fdf0");
		
		String responseBody=response.getBody().asString();
		
		System.out.println("the value of the response is ===>"+responseBody);
		
		int statuscode=response.getStatusCode();
		//Assert.assertEquals(statuscode, 200);
		if(statuscode==200) {
			System.out.println("pass");
		}else {
			System.out.println("fail and actual status code is ==>"+statuscode);
		}
		
		
		
		
		
	}

}
