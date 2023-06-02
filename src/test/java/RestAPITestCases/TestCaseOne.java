package RestAPITestCases;

import java.util.ArrayList;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import POJO.Category;
import POJO.Pet;
import POJO.Tag;
import java.io.File;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

//TASK 4 API
public class TestCaseOne {
	
	RequestSpecification request;
	ResponseSpecification response;
	Response re ;
	JsonPath js ;
	Pet p;
	Tag t ;
	Category c ;
	ArrayList<String> list1;
	ArrayList<Tag> list2;
	
	@BeforeMethod()
	public void requestSpec() {
		 p = new Pet();
		 t = new Tag();
		 c = new Category();
		 list1 = new ArrayList<String>();
		 
		 list1.add("URL");
		 
//		 list2.add("tag2");
		 
		 p.setCategory(c);
		 p.setId(667);
		 p.setName("SNOOP");
		 p.setPhotoUrls(list1);
		 p.setStatus("PENDING");
		 
		 t.setId(345345);
		 t.setName("YOYO");
		 list2 = new ArrayList<Tag>();
		 list2.add(t);
		 
		 p.setTags(list2);
		 
		 c.setId(4545);
		 c.setName("DOG");
		
		
		 request = new RequestSpecBuilder()
				.setBaseUri("https://petstore.swagger.io")
				.setContentType(ContentType.JSON)
				.setBody(p)
				.build();
		
	System.out.println("");
	
	 response = new ResponseSpecBuilder()
			 .expectStatusCode(200)
			 .expectContentType(ContentType.JSON)
			 .expectResponseTime(Matchers.lessThan(7000L))
			 .expectBody(JsonSchemaValidator.
				      matchesJsonSchema(new File("C:/Automation/projects/RestAPIandDesignPatterns/src/test/java/JsonSchemaValidation/Pet.json")))
			 .build();
				
	}
	
	
	
	
	
	
	@Test
	public void petDetails() {
		 re = RestAssured
		.given()
		.spec(request)
		.when()
		.post("/v2/pet")
		.then()
		.spec(response)
		.extract()
		.response();
		 
		 System.out.println("StatusCode :: "+ re.getStatusCode());
		//System.out.println("Headers :: "+ re.getHeaders());
		// System.out.println("Cookies :: "+ re.getCookies());
		 //System.out.println("Session ID :: "+ re.getSessionId());
		 System.out.println("Full Output :: "+re.asPrettyString());
		 
		  js = new JsonPath(re.asString());
		  int id = js.get("id");
		  String nameOfPet = js.get("name");
		  String typeOfPet = js.get("category.name");
		  String status = js.get("status");
		  String tag = js.get("tags[0].name");
		  
		  System.out.println(nameOfPet+" "+typeOfPet+" "+status+ " "+tag);
		  
		  Assert.assertEquals("SNOOP", nameOfPet);
		  Assert.assertEquals("DOG", typeOfPet);
		  Assert.assertEquals("PENDING", status);
		  
		 
	}
	
	
	

}
