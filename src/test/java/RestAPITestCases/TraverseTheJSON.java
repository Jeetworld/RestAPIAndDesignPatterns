package RestAPITestCases;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import groovy.json.JsonParser;
import io.restassured.path.json.JsonPath;

public class TraverseTheJSON {
	
	@Test
	public void traverseTheJSON() throws FileNotFoundException, IOException, ParseException {
		
		//get the payload from external .json file
		
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("AddPlace.json"));
		JSONObject jsoObject = (JSONObject)obj;
		System.out.println("full outut ::"+jsoObject.toString());
		
		JsonPath js = new JsonPath(jsoObject.toString());
		System.out.println("Accuracy == "+js.get("accuracy"));
		System.out.println("location lang == "+js.get("location.lng"));	//nested json
		System.out.println("location lat  == "+js.get("location.lat"));	//nested json
		System.out.println("Accuracy == "+js.get("types[0]"));
		
		System.out.println("Accuracy == "+js.get("types[0].first"));
		System.out.println("Accuracy == "+js.get("types[0].second"));
		
		System.out.println("nested to nested value1  json == "+ js.get("location.cityy.value1"));
		System.out.println("nested to nested value2  json == "+ js.get("location.cityy.value2"));
		//System.out.println("JSON PATH IS Accuracy "+js.get("types[1]"));
		
	}

}
