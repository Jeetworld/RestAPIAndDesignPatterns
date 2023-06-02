package RestAPITestCases;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestCaseTwo {
	//TASK 3 API
	Response response;
	JsonPath js;
	JsonPath jsonPath;
	RequestSpecification request;
	
	@BeforeClass
	public void setUp() {
		
		 request = RestAssured
				.given()
				.baseUri("https://jsonplaceholder.typicode.com");
	}
	
	@Test
	public void getPosts() {
		 response = request
				.when()
				.get("/posts")
				.then()
				.assertThat()
				.statusCode(200)
				.extract()
				.response();
		 
		 System.out.println("Full Output :: "+ response.asPrettyString());
		 System.out.println("StatusCode :: "+ response.getStatusCode());
		 
		 js = new JsonPath(response.asString());
		 List<Integer> userIds = js.getList(" findAll {it.id > 75}.userId ");
		
		 
		 System.out.println("All userids which have id greater than 75  :: "+userIds);
		 
	}
	
	@Test
	public void postPosts() {
		
		 response = request
				 .body("{\r\n"
				 		+ " \r\n"
				 		+ "  \"title\": \"YOYOH\",\r\n"
				 		+ "  \"body\": \"YOYOBODY\",\r\n"
				 		+ "  \"userId\": 65\r\n"
				 		+ "}")
					.when()
					.post("/posts")
					.then()
					.extract()
					.response();
		 
		 System.out.println("Full Output :: "+ response.asPrettyString());
		 System.out.println("StatusCode :: "+ response.getStatusCode());
	}
	
	@Test
	public void updatePosts() {
		
		 response = request
				 .body("{\r\n"
				 		+ "  \"id\": 100,\r\n"
				 		+ "  \"title\": \"YOYOHff\",\r\n"
				 		+ "  \"body\": \"YOYOBODYdd\",\r\n"
				 		+ "  \"userId\": 10\r\n"
				 		+ "}")
					.when()
					.put("/posts/100")
					.then()
					.extract()
					.response();
		 
		 System.out.println("Full Output :: "+ response.asPrettyString());
		 System.out.println("StatusCode :: "+ response.getStatusCode());
	}
	
	@Test
	public void deletePosts() {
		
		 response = request
					.when()
					.delete("/posts/100")
					.then()
					.extract()
					.response();
		 
		 System.out.println("Full Output :: "+ response.asPrettyString());
		 System.out.println("StatusCode :: "+ response.getStatusCode());
	}
	
	

}
