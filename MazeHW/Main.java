import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 3;
		boolean [][] visitedTest = new boolean [n][n];
		int [][] maze = new int[n][n];
		Random rand = new Random();
		
		maze[0][0] = 1;
		int x = 0;
		for (int i = 1; i<maze.length; i++) {
			
			for (int j = 1; j < maze.length; j++) {
				x = rand.nextInt(2);
				
				maze[i][j] = x;
				
			}
			
		}
		maze[n-1][n-1] = 1;
		
		
		Maze testOne = new Maze(n);
		testOne.setMaze(maze); //to change the maze to be solved pass in an alternate maze with size n
		
		Maze testTwo = new Maze(n);
		testTwo.setMaze(maze);
		
		
		
		
		   for (int k = 0; k<maze.length;k++) {
			
			for (int q = 0; q<maze.length; q++) {
				System.out.print(maze[k][q]);
			}
			System.out.println();
		}
		 
		  
		 

		if(testOne.solveMazeRecursive(0, 0)) { //recursive test, prints out the visited locations from visited array
			visitedTest = testOne.getVisited();
			
			for (int g = 0; g<visitedTest.length;g++) {
				for( int p = 0; p<visitedTest.length;p++) {
					if (visitedTest[g][p]) {
						System.out.print("(" + g + "," + p + ")" );
					}
				}
			}
		} else System.out.println("No recursive solution");
		
		//else System.out.println("false");
		System.out.println();
		System.out.println(testTwo.solveMazeStack()); //solves maze using the stack method and prints path to output
		
		//output will be recursive solution first with stack solution under with this current Main.java file
		
	}
	

}
