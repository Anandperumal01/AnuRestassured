package Dataparameterisation;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utility.XLUtils;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Addcustomer {
	
	
	@Test(dataProvider="getData")
	public void addcustomer(String CustomerName,String CustomerAddress
,String CustomerMobileNumber
,String Customerid
) {
		System.out.println(" i am in getall the customers");
		
		// Specify the your baseURI information
		RestAssured.baseURI="http://localhost:3000";
		// 54ee
		// Creating the Request object
		RequestSpecification httprequest=RestAssured.given();
		// sending the request to server and also recieveing the response
		
		JSONObject requestparameters=new JSONObject();
		requestparameters.put("Customerid", Customerid);
		requestparameters.put("CustomerName", CustomerName);
		requestparameters.put("CustomerAddress", CustomerAddress);
		requestparameters.put("CustomerMobileNumber", CustomerMobileNumber);
		
		httprequest.header("Content-Type","application/json");
		httprequest.body(requestparameters.toJSONString());
		
		
		
		
		
		Response response=httprequest.request(Method.POST, "/customers");
		
		String responseBody=response.getBody().asString();
		
		System.out.println("the value of the response is ===>"+responseBody);
		
		int statuscode=response.getStatusCode();
		//Assert.assertEquals(statuscode, 200);
		if(statuscode==201) {
			System.out.println("pass");
		}else {
			System.out.println("fail and actual status code is ==>"+statuscode);
		}
		
		// All the headers:
		Headers allheaders=response.headers();
		
		for(Header header:allheaders) {
			System.out.println(header.getName()+"====> "+header.getValue());
		}
		
	}
	
	@DataProvider
	public String[][] getData() throws IOException {
		String ExcelFile="D:\\Anu\\RestAssured\\src\\test\\resources\\TestData\\TestData.xlsx";
		
		int rowcount=XLUtils.getRowCount(ExcelFile,"Sheet1");
		int colcount=XLUtils.getcolCount(ExcelFile, "Sheet1", 1);
		String[][] customerdata=new String[rowcount][colcount];
		
		for(int i=1;i<=rowcount;i++) {
			
			for(int j=0;j<colcount;j++) {
				customerdata[i-1][j]=XLUtils.getcellvalue(ExcelFile, "Sheet1", i, j);
				
			}
		}
		
		return customerdata;
		
		
		
	}


}
