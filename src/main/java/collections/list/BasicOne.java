package collections.list;
import java.util.*;

public class BasicOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		ArrayList<String> list = new ArrayList<String>();
		list.add("apple");
		list.add("banana");
		list.add("zebra");
		list.add("apple");
		
		list.forEach(x -> System.out.println(x));
		
		LinkedList<String> list1 = new LinkedList<String>();
		list1.add("ROnny");
		list1.add("ABCY");
		list1.add("Zebra");
		list1.add("Cat");
		
		list1.forEach(x -> System.out.println(x));		//fasts in manipulation bec no shifting is required

	}

}
