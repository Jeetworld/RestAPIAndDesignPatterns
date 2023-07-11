package programming;
import java.util.*;

public class MapQ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("apple", 2);
		map.put("mango", 5);
		map.put("banana", 6);
		map.put("watermelon", 1);
		map.put("chiku", 3);
		
		//unsorted manner
		for(Map.Entry<String, Integer> list : map.entrySet()){
			System.out.println(list.getKey()+" "+list.getValue());
		}
		
		//sorted by value
		List<Integer> l = new ArrayList<Integer>();
		for(Map.Entry<String, Integer> list1 : map.entrySet()){
			l.add(list1.getValue());
		}
		
		Collections.sort(l);
		System.out.println(l);
		
		for(Integer i : l) {
			for(Map.Entry<String,Integer> m : map.entrySet()) {
				if(m.getValue().equals(i)) {
					
				}
			}
		}
	}

}
