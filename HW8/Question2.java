import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Question2 {
	
	public String concat(ArrayList<String> list) {
		
		HashMap<String, Integer> words = new HashMap<String, Integer>();
		String current;
		String first;
		String last;
		
		
		for(int k = 0; k<list.size();k++) {
			words.put(list.get(k), k);
		}
		
		
		for(int i = 0; i<list.size();i++) {
			current = list.get(i);
			
			for(int j = 0; j<current.length();j++) {
				first = current.substring(0, j);
				last = current.substring(j,current.length());
				
				if(words.containsKey(first) && words.containsKey(last)) { 
					
					if(words.get(first) == words.get(last)) { //avoids concat of same strings to make word
						continue;
					}
					else { 
						String output = "Yes, " + first + " at location " + words.get(first) + " and " + last + " at location " +
						words.get(last) + " together form " + current + " at " + words.get(current);
						
						return output;
					}
					
				}
			}
			
		}
		
		return "no concatinations found";
	}
	
	
	
	
}
