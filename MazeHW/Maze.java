import java.util.Stack;

public class Maze {
	private int[][] maze;
	private boolean[][] visited;
	
	
	public Maze(int n) {
		this.maze = new int [n][n]; //this is the maze to be solved by either method
		this.visited = new boolean[n][n]; //visited maze is updated as maze is solved
		
		
	}
	public boolean[][] getVisited() {
		return visited;
	}
	public int[][] getMAze() {
		return maze;
	}
	public void setMaze(int[][] maze) {
		this.maze = maze;
	}
	public void setMaze(int x,int y, int v) {
		this.maze[x][y] = v;
	}
	public void setVisited(int x,int y, boolean v) {
		this.visited[x][y] = v;
	}
	
	//setter and getter methods above 

	public boolean solveMazeRecursive(int x, int y) {
		
		if(x== maze.length-1 && y==maze.length-1) { //terminating condition
			visited[x][y] = true;
			return true;
		}else {
			if(isSafe(x,y)) {
				
				visited[x][y] = true;
				
				
				if(solveMazeRecursive(x,y+1)) {
					return true;
				}
				else if(solveMazeRecursive(x+1,y)) {
					return true;
				}
				else if(solveMazeRecursive(x,y-1)) {
					return true;
				}
				else if(solveMazeRecursive(x-1,y)) {
					return true;
				}
			}
			return false;
		}
		
			
	
	}
	
	
	public boolean isSafe(int x, int y) { //returns false if not safe true if safe and not visited
		
		if(x >= maze.length || x < 0) {
			
			return false;
		}
		else if(y >= maze.length || y < 0) {
			
			return false;
		}
		else if(maze[x][y] == 0) {
			
			return false;
		}
		else if(this.visited[x][y]) {
			
			return false;
		}
		else return true;
		
		
	} //end isSafe
	
	public String solveMazeStack() {
		int max = maze.length-1;
		Stack<Point> stack = new Stack<Point>();
		String out = "";
		int x = 0;
		int y = 0;
		
		if(isSafe(x,y)) {
			visited[x][y] = true;
			stack.push(new Point(x,y));
			out = out +new Point(x,y).toString();
		}
		else {
			return "no stack solution";
		}
		Point current = new Point(0,0);
		
		while(x != max || y != max) { //condition means reached end of maze
			
			if(isSafe(x,y+1)) { //checks right
				stack.push(new Point(x,y+1));
				visited[x][y+1] = true;
				
			}
			if(isSafe(x+1,y)) { //checks down
				stack.push(new Point(x+1,y));
				visited[x+1][y] = true;
				
			}
			if(isSafe(x,y-1)) {
				stack.push(new Point(x,y-1));
				visited[x][y-1] = true;
				
			}
			if(isSafe(x-1,y)) { 
				stack.push(new Point(x-1,y));
				visited[x-1][y] = true;
			
			}
			
			if(!stack.isEmpty()) {
				current = stack.pop();
				out = out + current.toString();
				x = current.getX();
				y = current.getY();
			} 
			else return "No stack solution";
			
		}
		
		return out;

		
	}
	
	
	
	
	}