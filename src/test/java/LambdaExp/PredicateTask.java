package LambdaExp;
import java.util.*;
import java.util.stream.Collectors;

public class PredicateTask {

//3. Print all the products from the given list of product if the product price is greaterthan 100/- which are in electronics category.
	
	String name, category, grade;
	int price ;
	PredicateTask(String a, int b, String c, String d) {
        name = a;
        price = b;
        category =c;
        grade = d;
        
    }
    int getPrice() { return price; }
    String getName() { return name; } 
    String getCategory() { return category; } 
    String getGrade() { return grade; } 
    
    public String toString() {
    return "User Name : " + name + " Pirce :" + price + " category "+category + " grade "+ grade;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 List<PredicateTask> product =   new ArrayList<PredicateTask>();
		product.add(new PredicateTask("arav", 122 , "A" , "Aone" ) );
		product.add(new PredicateTask("aanav", 2 , "A" , "Aone" ) );
		product.add(new PredicateTask("rahul", 278 , "B" , "Bone" ) );
		product.add(new PredicateTask("wohu", 101 , "B" , "Aone" ) );
		
		 List result = product.stream().filter((pro) -> pro.getName().equals("arav"))
				    .collect(Collectors.toList());
				          
				    System.out.println(result);
				    
				    List result2 = product.stream().filter((pro) -> pro.getPrice()>100).filter((pro) -> pro.getName().equals("arav"))
						    .collect(Collectors.toList());
				    System.out.println(result2);
		
		

	}

}
