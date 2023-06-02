package RestAPITestCases;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;


import POJO.ExtractJSONintoPOJO;
import POJO.AddPlaceFit;
import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class AddPlaceTestCase {
	
	@Test
	public void addPlace() throws JsonProcessingException {
		
		
		AddPlaceFit addPlace = new AddPlaceFit();
		//addPlace.objectDetails();
		
		RequestSpecification req = RestAssured
				.given()
				.baseUri("https://rahulshettyacademy.com")
				.header("Content-Type","application/json")
				//.config(config.logConfig(LogConfig.logConfig().blacklistHeader("Content-Type")))
				.config(RestAssured.config.logConfig(LogConfig.logConfig().blacklistHeader("Content-Type")))
				.queryParam("key", "qaclick123")
				.log()
				.all()
				.body(addPlace.fitDataToPOJO());
//				.body("{\r\n"
//						+ "  \"location\": {\r\n"
//						+ "    \"lat\": -38.383494,\r\n"
//						+ "    \"lng\": 33.427362\r\n"
//						+ "  },\r\n"
//						+ "  \"accuracy\": 50,\r\n"
//						+ "  \"name\": \"Frontline house\",\r\n"
//						+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
//						+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
//						+ "  \"types\": [\r\n"
//						+ "    \"shoe park\",\r\n"
//						+ "    \"shop\"\r\n"
//						+ "  ],\r\n"
//						+ "  \"website\": \"http://google.com\",\r\n"
//						+ "  \"language\": \"French-IN\"\r\n"
//						+ "}\r\n"
//						+ "");
				

		
		//*******METHOD 1 -- GET BODY INTO RESPONSE INTERFACE AND PASS INTO JSONPATH
		Response res = req
				.when()
				.post("/maps/api/place/add/json")
				.then()
				.assertThat()
				.statusCode(200)
				.log()
				.all()
				.extract()
				.response();
		System.out.println("Print the whole output ::"+res.asString());	//print full response with Response interface
		System.out.println("Status code ::"+res.getStatusCode());	//print status code with response interface
		
		JsonPath js = new JsonPath(res.asString()); //JsonPath accepts asString()
		System.out.println("Output of status is "+js.get("status"));
		System.out.println("Output of place_id is "+js.get("place_id"));
		System.out.println("Output of schope is "+js.get("scope"));
		System.out.println("Output of refernce is "+js.get("reference"));
		System.out.println("Output of id is "+js.get("id"));

		
//*******METHOD 2 -- DESERIALISE INTO CLASS AND FETCH VALUES
//		Response res = req
//				.when()
//				.post("/maps/api/place/add/json");
////		ResponseBody body = res.getBody()
////				.asString();
//		
//		ExtractJSONintoPOJO on= res.as(ExtractJSONintoPOJO.class);
//		System.out.println("Status code is == "+res.getStatusCode());
//		System.out.println("Place_ID = "+on.getPlace_id());
//		System.out.println("Status = "+on.getStatus());
//		System.out.println("Get ID = "+on.getId());
//		System.out.println("SCOPE = "+on.getScope());
//		System.out.println("Refrence = "+on.getReference());
		
		

		
		
	}

}
