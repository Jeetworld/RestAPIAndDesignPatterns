package LambdaExp;

import java.util.Collections;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.*;

public class lambdaExpTask {

	//String rev = "";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
//		***1. Check if a given string is a palindrome
		Function<String, Boolean> pr = str -> {
			String rev = "";
			boolean value =true;
				for(int i=str.length()-1; i>=0; i--) {
					rev = rev + str.charAt(i);
				}
				if(str.equals(rev)) {
					//System.out.println("Pallindrom no");
				}
				else {
					value= false;
				}
				
				return value;
		};
		
		System.out.println("Ouput is " +pr.apply("POPP"));
		System.out.println("Ouput is " +pr.apply("POP"));
		System.out.println("Ouput is " +pr.apply("helleh"));
		
		
//***		5. Use Comparator inerface to sort given list of numbers in reverse order
		
		 ArrayList<Integer> list=new ArrayList<Integer>();
		list.add(11);
		list.add(1);
		list.add(71);
		list.add(9);
		list.add(0);
		list.add(100);
		list.add(88);
		
		//one way to do that
		// Collections.sort(list, (o1, o2) -> (o2.compareTo(o1)));
	     //System.out.println("Descending order => " + list);
		
	     //second way to do that
	     Collections.sort(list, new MyComparator());
	     System.out.println("Descending order => " + list);
	     
	     //third way to do 
	     Comparator<Integer> c = (o1,o2) -> (o1<o2)?1:(o1>o2)?-1:0;
	     Collections.sort(list, c);
	     System.out.println("Descending order => " + list);
	     
//***10. Create a TreeMap that sorts the given set of employees in decending order of their name
	     
	     Map<String, Integer> empp = new TreeMap<>(); //hashmap stores in unordered way and treemap stored in asc order key values
	     
	      empp.put("Indian", 23);
	      empp.put("Chinese", 77);
	      empp.put("America", 44);
	      empp.put("Russia", 3);
	      empp.put("Brazil", 12);
	      empp.put("Mexico", 6);
	      empp.put("Pakistan", 3);
	 
	 
	     // empp.forEach((key, value) -> System.out.println("Key : " + key  + " "  + "Value : "  + value));
	 
	        
	        List<Map.Entry<String, Integer>> list2 = new LinkedList<>(empp.entrySet());
	        System.out.println("ooo"+list2);
	        Collections.sort(list2,  (map1, map2) -> map2.getKey().compareTo(map1.getKey())
	                );
	 
	        Map<String, Integer> tempMapDesc = new LinkedHashMap<>();
	        for (Map.Entry<String, Integer> map : list2) {
	            tempMapDesc.put(map.getKey(), map.getValue());
	        }
	        
	        tempMapDesc.forEach((key, value) -> System.out.println("Key : " + key  + " "  + "Value : "  + value));
	     
	     
		

	}

}
