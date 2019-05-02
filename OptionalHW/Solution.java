import java.util.HashMap;
import java.util.HashSet;

public class Solution {
	
/*
 To Dr. Sekharan or Alber,

	I have included a commented out main method in the solution.java file 
	The main method contains an example call to the solution method if it is uncommented 
  
 */
	

	public String solution(String time) {
		
				String noModTime = time;
				int index;
				int counter = 0;
				String s;
				String ss;
				HashSet<String> timeHash;
				String[] nums;
				String[] times = new String[1440];
				HashMap<String, Integer> translate = new HashMap<String, Integer>(); 
				
				time = time.replace(":", "");
				
				
				//creating timeline
				for(int i = 0; i< 24;i++) { //for loop run times are constant total of 1440 iterations
					
					if(i < 10) {
						s =  "0" + Integer.toString(i);
					}
					else s= Integer.toString(i);
					
					for(int j =0 ; j <60;j++) {
						if(j < 10) {
							ss =  "0" + Integer.toString(j);
						}
						else ss= Integer.toString(j);
						
						translate.put(s + ss, counter); //key is the time in format, value is the index in the times array
						times[counter] = s + ss; 
						counter++;
						
					}
				}
				
				index = translate.get(time); // O(1) to get the index in time array to start search 
				timeHash = new HashSet<String>();
				nums = time.split("");
				
				for(int l = 0; l < 4 ; l ++) { //adds all values in the time to the hashset, constant time
					timeHash.add(nums[l]);
				}
				//System.out.println(timeHash);
				
				if(timeHash.size() ==1) { //all values are the same 
					return noModTime;
				}
				else {
				
				while(index != 0) { //moves left from access point until reaches 00:00
					index--;
					String testTime = times[index];
					String[] testNums = testTime.split("");
					//System.out.println(testNums[0] + " " + testNums[1] + " " + testNums[2] + " " + testNums[3]);
					
					if(timeHash.contains(testNums[0]) && timeHash.contains(testNums[1]) && timeHash.contains(testNums[2])
							&& timeHash.contains(testNums[3])) {
						return (testNums[0] + testNums[1] + ":" + testNums[2] + testNums[3]);
						
					} //contains methods O(1)
					
					} 
				/*
				 * worst case is time 23:59, makes 1440 loops 
				 * iterations is the index of the time in the timeline
				 * overall time complexity is O(n)
				 */
				}
				
				return "Run finished with no results";
		
	}
	
	/*
	  public static void main(String[] args) {
		
		Solution example = new Solution();
		String a = example.solution("11:15");
		System.out.println(a);
		
		
	}
	 */
	
	 
	
}
