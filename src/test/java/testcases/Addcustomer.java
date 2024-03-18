package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Addcustomer {

	@Test
	public void addcustomer() throws IOException {
		Properties prop=new Properties();
		FileInputStream ip=new FileInputStream("D:\\Anu\\RestAssured\\src\\test\\resources\\Config\\Config.properties");
		prop.load(ip);
		String url=prop.getProperty("localhosturl");
		
		
		System.out.println(prop.getProperty("localhosturl"));
		
		System.out.println(" i am in getall the customers");

		// Specify the your baseURI information
		RestAssured.baseURI = url;
		// 54ee
		// Creating the Request object
		RequestSpecification httprequest = RestAssured.given();
		// sending the request to server and also recieveing the response

		JSONObject requestparameters = new JSONObject();
		requestparameters.put("Customerid", 3007);
		requestparameters.put("CustomerName", "Customer3007");
		requestparameters.put("CustomerAddress", "rwqrwar");
		requestparameters.put("CustomerMobileNumber", 888888);

		httprequest.header("Content-Type", "application/json");
		httprequest.body(requestparameters.toJSONString());

		Response response = httprequest.request(Method.POST, "/customers");

		String responseBody = response.getBody().asString();

		System.out.println("the value of the response is ===>" + responseBody);

		int statuscode = response.getStatusCode();
		// Assert.assertEquals(statuscode, 200);
		if (statuscode == 200) {
			System.out.println("pass");
		} else {
			System.out.println("fail and actual status code is ==>" + statuscode);
		}

		// All the headers:
		Headers allheaders = response.headers();

		for (Header header : allheaders) {
			System.out.println(header.getName() + "====> " + header.getValue());
		}

		Assert.assertEquals(responseBody.contains("Customer3007"), true);
		// responseBody.g

	}

}
