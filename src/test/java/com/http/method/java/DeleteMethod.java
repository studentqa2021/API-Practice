package com.http.method.java;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteMethod {
	
public void getDeleteTest() {
		
		Response response = RestAssured.delete("http://localhost:3000/posts/22");
		
		System.out.println("Status code ="+response.getStatusCode());//200
		Assert.assertEquals(response.getStatusCode(), 200);
		
		//System.out.println(response.getContentType());//json
		System.out.println("Data format ="+response.getContentType());
		//Assert.assertEquals(response.getContentType(), "application/json");
		Assert.assertTrue(response.getContentType().contains("json"));
		
		//System.out.println(response.getTime());//response time
		System.out.println("Response time"+response.getTime());
		Assert.assertTrue(response.getTime()<2000);
		
		//System.out.println(response.asString());//whole data
		//response.prettyPrint();
		System.out.println("Is response null or not =" +(response.toString()!= null));
		Assert.assertTrue(response.toString()!= null);
	}
	
	public static void main(String[] args) {
		new DeleteMethod().getDeleteTest();
	}

}
