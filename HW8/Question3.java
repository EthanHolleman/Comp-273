import java.util.*;
public class Question3 {

	public void diffs(int[] a, int k) {
		ArrayList<String> pairs = new ArrayList<String>();
		HashSet<Integer> vals = new HashSet<Integer>();
		Integer value;
		
		for(int q = 0; q<a.length;q++) {
			vals.add(a[q]);
		}
		
		for(int i = 0; i<a.length;i++) {
			value = a[i] - k;
			
			if(vals.contains(value)) {
				pairs.add("(" + a[i] + "," + value + ")");
			}
			
		}
		
		for(int j = 0; j<pairs.size();j++) {
			System.out.print(pairs.get(j) + ", ");
		}
		
		
	}
	
	
}
