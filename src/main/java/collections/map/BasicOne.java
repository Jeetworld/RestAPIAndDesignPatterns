package collections.map;
import java.util.*;

public class BasicOne {
	
	public static void main(String[] args)  {
		Map<String, Integer> map1 = new HashMap<String, Integer>();			//maintains no order
		map1.put("apple", 2);
		map1.put("cucumber", 3);
		map1.put("tinda", 6);
		map1.put("banana", 2);
		map1.put("chiku", null);
		map1.put("litchi", null);							//non synchronised
		map1.put(null, null);								//contains only one null key but multiple null values
		map1.put(null, null);
		map1.put(null, null);
		
		for(Map.Entry<String, Integer> ele : map1.entrySet()) {
			//System.out.println("KEY "+ ele.getKey()+" VALUE "+ele.getValue());
		}
		
		Map<String, Integer> map2 = new LinkedHashMap<>();	//maintains insertion order
		map2.put("apple", 4);				//non synchronised
		map2.put("cat", 4);					//one null key but multiple null values
		map2.put("dog", 4);
		map2.put("camel", 4);
		map2.put("zebra", null);
		map2.put(null, null);
		map2.put("elephant", null);
		map2.put(null, 5);
		map2.put("giraf", 8);
		
		for(Map.Entry<String, Integer> ele : map2.entrySet()) {
			//System.out.println("KEY "+ ele.getKey()+" VALUE "+ele.getValue());
		}
		
		Map<String, Integer> map3 = new TreeMap<>();	//sort in ASC order
		map3.put("apple", 4);				//non synchronised
		map3.put("cat", 4);					//NO null key but multiple null values
		map3.put("dog", 4);
		map3.put("camel", 4);
		map3.put("zebra", null);
		//map3.put(null, null);
		map3.put("elephant", null);
		//map3.put(null, 5);
		map3.put("giraf", 8);
		
		for(Map.Entry<String, Integer> ele : map3.entrySet()) {
			System.out.println("KEY "+ ele.getKey()+" VALUE "+ele.getValue());
		}
	}

}
