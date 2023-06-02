package collections.set;
import java.util.*;

public class BasicOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashSet<String> h = new HashSet<String>();	//maintains no order
		h.add("apple");
		h.add("zebra");
		h.add("cat");
		h.add("apple");
		h.add("mouse");
		h.add("bat");
		h.add("dog");
		
		//h.forEach(x -> System.out.println(x));
		
		LinkedHashSet<String> h1 = new LinkedHashSet<String>();		//maintains the insertion order
		h1.add("zebra");				//non synchronised
		h1.add("monkey");				//allow only one null value
		h1.add("dog");
		h1.add("cat");
		h1.add("apple");
		h1.add("elephant");
		h1.add("zebra");
		h1.add(null);
		h1.add(null);
		
		//h1.forEach(x -> System.out.println(x));
		
		
		TreeSet<String> h2 = new TreeSet<String>();		//maintains the ASC order
		//h2.add(null);			//no null value
		h2.add("apple");			//non synchronsed
		h2.add("dog");				//retrvival is fast
		h2.add("cat");
		h2.add("giff");
		h2.add("elephant");
		h2.add("zebra");
		h2.add("hp");
		
		h2.forEach(x -> System.out.println(x));
	}

}
