package com.http.method.testng;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestingGetMethod {
	Response response;
	
	@BeforeTest
	public void getsetup() {
		response = RestAssured.get("http://dummy.restapiexample.com/api/v1/employees");
	}
	
	@Test
	public void getStatusCode() {
		System.out.println("Status code ="+response.getStatusCode());//200
		Assert.assertEquals(response.getStatusCode(), 200);
	}
		
	@Test
	public void getContentType() {
		System.out.println("Data format ="+response.getContentType());
		Assert.assertEquals(response.getContentType(), "application/json");
		Assert.assertTrue(response.getContentType().contains("json"));
	}
	
	@Test
	public void getResponseTime() {
		System.out.println("Response time"+response.getTime());
		Assert.assertTrue(response.getTime()<2000);
	}
	
	@Test
	public void getResponseNullorNot() {
		System.out.println("Is response null or not =" +(response.toString()!= null));
		Assert.assertTrue(response.toString()!= null);
	}
	
	@AfterTest
	public void teardown() {
		
	}

}
