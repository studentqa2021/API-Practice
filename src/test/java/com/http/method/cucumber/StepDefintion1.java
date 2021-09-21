package com.http.method.cucumber;

import org.testng.Assert;

import com.google.gson.JsonObject;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StepDefintion1 {
	
	Response response;
	JsonObject json;
	
	@Given("Select HTTP Methods {string} and go to URL {string}")
	public void select_http_methods_and_go_to_url(String Method, String URL) {
		if(Method.contains("GET")) {
		response = RestAssured.get(URL);
		response.prettyPrint();
		}
		else if(Method.contains("DELETE")) {
			response = RestAssured.delete(URL+"2");
			response.prettyPrint();
		} 
		else if(Method.contains("POST")) {
			RequestSpecification request = RestAssured.given();
			request.header("Content-type", "application/json");
			
			request.body(json.toString());
			response = request.post(" http://localhost:3000/posts");
		}
	}
	
	@When("Pass Test Data\"POST\"")
	public void pass_test_data_post(String string) {
		json = new JsonObject();
	    json.addProperty("title", "Automation");
	    json.addProperty("author", "Student");
	}
	
	@When("Pass Test Data\"PUT\"")
	public void pass_test_data_put(String string) {
		json = new JsonObject();
	    json.addProperty("title", "Manual");
	    json.addProperty("author", "Student");
	    }

	@Then("Validate my test")
	public void validate_my_test() {
		System.out.println("Status code ="+response.getStatusCode());//200
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("Data format ="+response.getContentType());
		//Assert.assertTrue(response.getContentType().toString().contains("json"));
		Assert.assertTrue(response.getContentType().contains("json"));
		System.out.println("Response time"+response.getTime());
		Assert.assertTrue(response.getTime()<2000);
		System.out.println("Is response null or not =" +(response.toString()!= null));
		Assert.assertTrue(response.toString()!= null);
	   
	    
	}

}
