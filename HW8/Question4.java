import java.util.*;
public class Question4 {

	public void union(ArrayList<String> a, ArrayList<String> b) {
		Iterator<String> out;
		
		HashSet<String> union = new HashSet<String>();
		union.addAll(a);
		
		for(int i = 0; i<b.size();i++) {
			if(!union.contains(b.get(i))) {
				union.add(b.get(i));
			}
		}
		
		out = union.iterator();
		while(out.hasNext()) {
			System.out.print(out.next() + ",");
		}
		
	}
	
	
	
}
