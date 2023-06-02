package DesignPatterns.BuilderPattern;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class TestUserAPI {
	
	@Test
	public void  testUserAPI() {
		
		User user=new UserBuilder().setName("Varsha")
				.setJob("Engineer").build();		//here you can passs one argument or both arguments
		
		Response response = RestAssured
				.given()
				.baseUri("https://reqres.in")
				.contentType(ContentType.JSON)
				.log().all()
				.body(user)
				
				.when()
				.post("/api/users")
				.then()
				.body(JsonSchemaValidator.
					      matchesJsonSchema(new File("C:/Automation/projects/RestAPIandDesignPatterns/src/test/java/JsonSchemaValidation/ValidateUserAPI.json")))
				.extract()
				.response();
		
		System.out.println("Otput is "+response.asString());
		System.out.println("Status code is "+response.getStatusCode());
		System.out.println("Full Reponse in pretty format "+ response.asPrettyString());
		//System.out.println(" Few Details are "+ response.getContentType() + " Cookies::  "+ response.getCookies() + " SessionID "+ response.getSessionId() +" Headers "+response.getHeaders());
		//Assert.assertEquals(response.getStatusCode(),"201");
		
	}

}
