package com.http.method.java;

import org.testng.Assert;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutTestMethod {
	
	public void getTest() {
		
		// 1st ==> add test data = JsonObject class and addProperty
		JsonObject obj = new JsonObject();
		obj.addProperty("title", "Book");
		obj.addProperty("author", "Steve");
		
		// 2nd ==> RequestSpecification and add data inside body
		RequestSpecification rsf = RestAssured.given();
		rsf.body(obj); //passing test data inside the message body
		
		// 3rd ==> Pass the URL
		Response response = rsf.post("http://localhost:3000/posts/21");
			
		//4th ==> API Basic Validation 
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
			//Data Validation 
			//response.prettyPrint();
			System.out.println("Is response null or not =" +(response.toString()!= null));
			Assert.assertTrue(response.toString()!= null);
			//specific attribute value or how to parse json data
			
			JsonPath jp = response.jsonPath(); //to go to specific attribute
			Assert.assertTrue(jp.get("title") != null);
			
			Assert.assertEquals(jp.get("title").toString(), "Automation");
			Assert.assertEquals(jp.get("author").toString(), "Student");
		}
		
		public static void main(String[] args) {
			new PostTestMethod().getTest();
		}

	}





}
