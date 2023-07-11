package collections.map;
import java.util.*;
import java.util.Map.Entry;

public class SortTheValues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<Integer, String> m = new HashMap<Integer, String>();
		m.put(3, "Apple");
		m.put(1, "Mango");
		m.put(5, "Banana");
		
		List<Map.Entry<Integer, String>> list = new LinkedList<Map.Entry<Integer, String>>(m.entrySet());
		//Collections.sort(list, (o1,02) -> 	o1.getValue().compareTo(o2.getValue()));
		 Collections.sort(list,(i1,i2) -> i1.getValue().compareTo(i2.getValue()));	
		  HashMap<String, Integer> temp
          = new LinkedHashMap<String, Integer>();
		  
		  System.out.println("YYOY"+list);
		 for (Map.Entry<Integer, String> aa : list) {
	            temp.put(aa.getValue(), aa.getKey());
	        }
		 
		 for (Entry<String, Integer> en : temp.entrySet()) {
            System.out.println("Key = " + en.getKey()
                               + ", Value = "
                               + en.getValue());
	}

}
}
