package com.http.method.java;

import org.testng.Assert;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostTesting {
	
public void getTest() {
	
	// 1st ==> add test data = JsonObject class and addProperty
	JsonObject obj = new JsonObject();
	obj.addProperty("title", "Automation");
	obj.addProperty("author", "Student");
	
	// 2nd ==> RequestSpecification and add data inside body
	RequestSpecification rsf = RestAssured.given();
	rsf.header("Content-type", "application/json");
	rsf.body(obj); //passing test data inside the message body
	
	// 3rd ==> Pass the URL
	Response response = rsf.post("http://localhost:3000/posts");
		
	//4th ==> Validate
		System.out.println("Status code ="+response.getStatusCode());//201
		Assert.assertEquals(response.getStatusCode(), 201);
		
		//System.out.println(response.getContentType());//json
		System.out.println("Data format ="+response.getContentType());
		//Assert.assertEquals(response.getContentType(), "application/json");
		Assert.assertTrue(response.getContentType().contains("json"));
		
		//System.out.println(response.getTime());//response time
		System.out.println("Response time"+response.getTime());
		Assert.assertTrue(response.getTime()<2000);
		
		//System.out.println(response.asString());//whole data
		response.prettyPrint();
		System.out.println("Is response null or not =" +(response.toString()!= null));
		Assert.assertTrue(response.toString()!= null);
	}
	
	public static void main(String[] args) {
		new PostTesting().getTest();
	}

}



