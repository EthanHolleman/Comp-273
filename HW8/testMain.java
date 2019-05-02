import java.util.*;
public class testMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> test = new ArrayList<String>();
		ArrayList<String> testA = new ArrayList<String>();
		test.add("abcc");
		test.add("abcabc");
		test.add("abc");
		test.add("c");
		
		
		
		testA.add("a");
		testA.add("b");
		testA.add("b");
		testA.add("c");
		
		Question4.union(test, testA);
		
		//----------------- Question 4 testing area above
		System.out.println();
		System.out.println("Question 3 Testing");
	
		int[] testDiff = new int[20];
		for(int i = 0; i<20;i++) {
			testDiff[i] = i;
		}
		
		Question3.diffs(testDiff, 18);
		
		//-------------------------- Question 1\
		System.out.println("\nQuestion 1 test");
		ExtArrayList<String> extOne = new ExtArrayList<String>();
		ExtArrayList<String> extTwo = new ExtArrayList<String>();
		
		extOne.add("hellos"); //problem with duplicates 
		extOne.add("a");
		//extOne.add("a");
		extOne.add("this");
		extOne.add("never");
		
		extTwo.add("never");
		extTwo.add("a");
		extTwo.add("this");
		extTwo.add("hellos");
		//extTwo.add("a");
	
		
		
	
		System.out.println(extOne.equals(extTwo));	
		
		//----------------------
		System.out.println(Question2.concat(test));
		
		
		
	}
	

}
