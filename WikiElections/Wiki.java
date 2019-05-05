
import java.io.*;
import java.util.*;


public class Wiki {
	
	Scanner fileScanner;
	String textFileName ="/home/ethan/Documents/Comp/HW10/wikiElec.txt"; //change these to locations 
	HashMap <String, String> translateID = new HashMap<String, String>();
	HashMap <String, HashMap<String, int[]>> voteHist = new HashMap <String, HashMap<String, int[]>>();
	HashMap <String, ArrayList<String[]>> electionHist =  new HashMap <String, ArrayList<String[]>>();
	
	public void readFile() {
		String currentResult = "";
		String currentCanID= "";
		String currentCanName= "";
		String currentNomName= "";
		String currentNomID= "";
		String voterID = "";
		String voterName = "";
		String vote = "";
		String line=null;
		try
		
        {

            fileScanner = new Scanner (new File (textFileName));
            //skipping over the first few lines 
            line = fileScanner.nextLine();
        	line = fileScanner.nextLine();
        	line = fileScanner.nextLine();
        	line = fileScanner.nextLine();
        	line = fileScanner.nextLine();
        	line = fileScanner.nextLine();
            
            while (fileScanner.hasNext()) {
            	
            	line = fileScanner.nextLine();
            	String[] words=line.split("\t");
            	
            	
            	if(words[0].equals("E")) {
            		currentResult = words[1];
            		
            	}
            	else if(words[0].equals("U")) {
            		currentCanName = words[2];
            		currentCanID = words[1];
            		translateID.put(currentCanName, currentCanID);
            	}
            	else if(words[0].equals("N")) {
            		currentNomName = words[2];
            		currentNomID = words[1];
            		translateID.put(currentNomName, currentNomID);
            		
            		if(electionHist.containsKey(currentCanID)) {
            			electionHist.get(currentCanID).add(new String[] {currentNomID,currentNomName,"0","0","0",currentResult });
            		}
            		else {
            			electionHist.put(currentCanID, new ArrayList<String[]>());
            			electionHist.get(currentCanID).add(new String[] {currentNomID,currentNomName,"0","0","0",currentResult });
            			
            		}
            		
            		
            	}
            	else if(words[0].equals("V")) {
            		
            		voterID = words[2]; 
            		voterName = words[4];
            		vote = words[1];
            		translateID.put(voterName, voterID);
            		
            		int numRaces = electionHist.get(currentCanID).size(); //number of previous elections user has run in
        			
        			boolean y = false;
        			boolean n = false;
        			boolean nl = false;
        			
            		
            		if(vote.equals("1")) { //calculations for adjusting current canidate election outcomes
            			y = true; //now know vote in current election = +
            			int yes = Integer.parseInt(electionHist.get(currentCanID).get(numRaces -1)[2]); 
            			yes++;
            			electionHist.get(currentCanID).get(numRaces-1)[2] = Integer.toString(yes);
            		}
            		else if(vote.equals("0")) {
            			nl = true;
            			int neutral = Integer.parseInt(electionHist.get(currentCanID).get(numRaces -1)[3]);
            			neutral++;
            			electionHist.get(currentCanID).get(numRaces-1)[3] = Integer.toString(neutral);
            		}
            		else {
            			n = true;
            			int no = Integer.parseInt(electionHist.get(currentCanID).get(numRaces -1)[4]);
            			no++;
            			electionHist.get(currentCanID).get(numRaces-1)[4] = Integer.toString(no);
            		}

            		if(voteHist.containsKey(voterID)) { //check if person has voted before (in votehist)
            			
            			if(voteHist.get(voterID).containsKey(currentCanID)) { //check if they have voted for this canidate before
            				
            				if(y) {
                				voteHist.get(voterID).get(currentCanID)[0] ++;	
                			}
                			else if(nl) {
                				voteHist.get(voterID).get(currentCanID)[1]++;
                			}
                			else if(n) {
                				voteHist.get(voterID).get(currentCanID)[2]++;
                			}
            				
            				
            				
            			}
            			else { //have voted before but not fot this person
            				voteHist.get(voterID).put(currentCanID, new int[3]);
            				
            				if(y) {
                				voteHist.get(voterID).get(currentCanID)[0] ++;	
                			}
                			else if(nl) {
                				voteHist.get(voterID).get(currentCanID)[1]++;
                			}
                			else if(n) {
                				voteHist.get(voterID).get(currentCanID)[2]++;
                			}
            				
            			}
            			
            		}
            		else { //voter has not voted before (not in votehist)
            			voteHist.put(voterID, new HashMap<String, int[]>());
            			
            			voteHist.get(voterID).put(currentCanID, new int[3]);
            			
            			
            			if(y) {
            				voteHist.get(voterID).get(currentCanID)[0] ++;	
            			}
            			else if(nl) {
            				voteHist.get(voterID).get(currentCanID)[1]++;
            			}
            			else if(n) {
            				voteHist.get(voterID).get(currentCanID)[2]++;
            			}
            			
            			
            		}
            	}

             }
  
            
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
		
		
		
	}
	
	public void getVotingHist(String userID) {
		
		if(voteHist.containsKey(userID)) {
			
			//HashMap <String, HashMap<String, int[]>> voteHist	
			
			
			int totalUp = 0;
			int totalDown = 0;
			int totalNewt = 0;
			
			
			for(String canidate : voteHist.get(userID).keySet()) { //all people they have voted for
				totalUp += voteHist.get(userID).get(canidate)[0];
				totalDown += voteHist.get(userID).get(canidate)[2];
				totalNewt += voteHist.get(userID).get(canidate)[1];
			}
			System.out.println("Voting History for " + userID);
			System.out.println("Total Upvotes: " + totalUp);
			System.out.println("Total Downvotes: " + totalDown);
			System.out.println("Total Neutral Votes: " + totalNewt + "\n");
		}
		else {
			System.out.println(userID + " has not voted in any elections\n");
		}
		
		
		
	}
	
	
	
	public void totalVotes(String userName) {
		
		String userID = translateID.get(userName);
		
		if(electionHist.containsKey(userID)){
			ArrayList<String[]> elections = electionHist.get(userID);
			System.out.println("Total Votes for " + userName);
			System.out.println("___________________________________");
			for(int i = 0; i< elections.size(); i++) {
				
				System.out.println("Election " + (i+1) );
				System.out.println("Support Votes: " + elections.get(i)[2]);
				System.out.println("Neutral Votes: " + elections.get(i)[3]);
				System.out.println("Opposition Votes: " + elections.get(i)[4]);
				
				
				if(elections.get(i)[5].equals("1")) {
					System.out.println("They were elected: Result = 1\n");
				}
				else System.out.println("They were not elected: Result = 0\n");
			}
			
			
		}
		else {
			System.out.println(userName + " has not run in an election\n");
		}
	
	}
	
	public void getNominator(String userID) {
		
		//HashMap <String, ArrayList<String[]>> electionHist
		try {
		ArrayList<String[]> elections = electionHist.get(userID); //get arraylist containing all elctions user has run in
		
		
		if(elections.size() == 0) { //if ararylist is empty user has not run
			System.out.println("User with ID" + userID + " has never run in an election");
		}
		
		
		for(int i = 0; i<elections.size(); i++) { //iterate through all elections access info my index O(n) n = number elections
			
			String[] election = elections.get(i);
			System.out.println("Election " + (i+1) + " for " + userID);
			System.out.println("Nominator Name: " + election[1]);
			System.out.println("Nominator ID: " + election[0]);
			System.out.println();
			
			
		}
		}
		catch (NullPointerException e) { //ArrayList does not exist, means no recorded election hist 
			System.out.println("User has not run in an election");
		}
		
	}
	
	
	public void getDownvotePairs() {
		int counter = 0;
		//get the keys from the election list 
		
		HashMap<String, String> myNewHashMap = new HashMap<String, String>();
		for(HashMap.Entry<String, String> entry : translateID.entrySet()){
		    myNewHashMap.put(entry.getValue(), entry.getKey());
		}
		HashSet<String> oneWayPairs = new HashSet<String>(); //used to eliminate pairs printing twice (AB and BA)
		
		
		for(String user : voteHist.keySet()) { //loops through all users who have run (both must have run)
			
			
			HashMap<String, int[]> votes = voteHist.get(user);
			
			
			for(String canidate : votes.keySet()) {
				//all people that the person on outer loop has voted for
				if(votes.get(canidate)[2] > 0) { //outer loop person has downvoted the current inner loop ID
					
					
					if(voteHist.containsKey(canidate)) { //vote hist contains the potential match
						
			
						if(voteHist.get(canidate).containsKey(user)) { //the canidate has voted for the user
							
							if(voteHist.get(canidate).get(user)[2] > 0) { //the canidate has voted -1 for the user at least once
								
								if(!canidate.equals(user)) { //canidate and user are not the same 
									String combo = canidate + user;
									
									if(!oneWayPairs.contains(combo)) { //checks to make sure the BA is not present (vs AB pair)
										oneWayPairs.add(user+canidate);
										System.out.println(myNewHashMap.get(canidate) + " " + myNewHashMap.get(user));
										counter++;
									}

								}
								
							}
							
						}
						
					}
				}
	
			}
	
		}
		
		System.out.println(counter + " total mutually downvoted pairs");
	
	}
	
	public static void main(String[] args){
		Wiki test = new Wiki();
		test.readFile();
		System.out.println("Question 1\n");
		test.getVotingHist("7397");
		test.getVotingHist("8263");
		
		System.out.println("Question 2\n");
		test.getNominator("32");
		test.getNominator("10");
		
		System.out.println("Question 3\n");
		test.totalVotes("sam_vimes");
		test.totalVotes("gromlakh");
		
	
		System.out.println("Question 4\n");
		test.getDownvotePairs();
		
	}
	
	
}
	
	
	


