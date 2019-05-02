import java.util.*;

public class ExtArrayList<E> extends ArrayList<E>{
	
	
	public boolean equals(ExtArrayList<E> eal) {
		HashMap<E, Integer> look = new HashMap<E, Integer>();
		HashMap<E, Integer> lookEal = new HashMap<E, Integer>();
		int temp;
		
		
		for(int i = 0; i<this.size();i++) { 
			if(look.containsKey(this.get(i))) {
				temp = look.get(this.get(i));
				look.put(this.get(i), temp+1);
			}
			else {
				look.put(this.get(i), 1);
			}
			
		}
	
		
		
		for(int k = 0; k<eal.size();k++) {
			if(lookEal.containsKey(eal.get(k))) {
				temp = lookEal.get(eal.get(k));
				lookEal.put(eal.get(k), temp+1);
			}
			else {
				lookEal.put(eal.get(k), 1);
			}
		}
		
		
		if(look.equals(lookEal)) {
			return true;
		}
		else return false;
		
	
		
		
	}
}
