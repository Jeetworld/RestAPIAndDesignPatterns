package POJO;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import POJO.AddPlacePOJO;
import POJO.Location;

public class  AddPlaceFit {
	
	AddPlacePOJO obj = new AddPlacePOJO();
	@Test
	public AddPlacePOJO fitDataToPOJO() throws JsonProcessingException {
		ArrayList<String> str = new ArrayList<String>();
		str.add("first");
		str.add("second");
		
		Location loc = new Location();
		loc.setLat(33.12);
		loc.setLng(22.33);
		
	//AddPlacePOJO obj = new AddPlacePOJO();
	obj.setAccuracy(22);
	obj.setAddress("H.N 122, New GAD Nagar");
	obj.setLanguage("Punjabi");
	obj.setName("Kamal");
	obj.setPhone_number("+3242323");
	obj.setWebsite("www.google.com");
	obj.setTypes(str);			//it accepts the ArryList
	obj.setLocation(loc);		//it accepts the Location object
	
	 ObjectMapper mapper = new ObjectMapper();
     String employeeJson = mapper.writeValueAsString(obj);
     String employeePrettyJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
     System.out.println("first ouput is "+employeeJson);
     System.out.println("second output is "+employeePrettyJson);
	return obj;
	
	}
	
	
}
